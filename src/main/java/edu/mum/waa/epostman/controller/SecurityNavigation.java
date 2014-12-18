package edu.mum.waa.epostman.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.waa.epostman.domain.MailItem;
import edu.mum.waa.epostman.domain.Role;
import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.service.MailItemService;
import edu.mum.waa.epostman.service.UserService;
import edu.mum.waa.epostman.validator.ConfirmPasswordValidator;
import edu.mum.waa.epostman.validator.UniqueUserNameAndPasswordValidator;

@Controller
@SessionAttributes("authenitcatedUser")
public class SecurityNavigation {

	@Autowired
	UserService userService;

	@Autowired
	ConfirmPasswordValidator confirmPasswordValidator;
	
	@Autowired
	UniqueUserNameAndPasswordValidator uniqueUserNameAndPasswordValidator;
	
	@Autowired
	private MailItemService mailItemService;

	@RequestMapping(value = "/")
	public ModelAndView mainPage(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(
				"authenitcatedUser");
		ModelAndView modelAndView = null;
		if (user != null) {
			modelAndView = new ModelAndView("layouts/main");

			modelAndView.addObject("partials", "user/dashboard");
		} else {
			modelAndView = new ModelAndView("login-form");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register-form";
	}

	@RequestMapping("/register-success")
	public String registerSuccessPage() {
		return "register-success";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String pocessRegister(@ModelAttribute("user") @Valid User newUser,
			BindingResult result, Model model) {

		confirmPasswordValidator.validate(newUser, result);
		uniqueUserNameAndPasswordValidator.validate(newUser, result);
		
		if (result.hasErrors()) {
			return "register-form";
		}
		newUser.setRole(Role.User);
		User user = userService.saveUser(newUser);
		if (user != null) {
			return "redirect:/register-success";
		} else {
			model.addAttribute("message",
					"Sorry!!! Problem Occured in User Registration.");
			return "register-form";
		}
	}

	/*
	 * @RequestMapping(value = "/dashboard") public ModelAndView successLogin()
	 * { ModelAndView modelAndView = new ModelAndView("welcome"); User
	 * user=(User) SecurityContextHolder.getContext()
	 * .getAuthentication().getPrincipal();
	 * modelAndView.addObject("authenitcatedUser", user); return modelAndView; }
	 */

	@RequestMapping(value = "/dashboard")
	public ModelAndView showDashboard(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("layouts/main");

		modelAndView.addObject("partials", "user/dashboard");
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		modelAndView.addObject("authenitcatedUser", user);
		if (user.getRole().getValue() == 1) {
			List<MailItem> mailItems = mailItemService
					.getAllMailItemByUserId(user.getId());

			List<User> mailSharedUsers = userService.getAllUserByMailBoxId(user
					.getMailBox().getId(), user.getId());
			modelAndView.addObject("mailBoxNumber", user.getMailBox()
					.getmNumber());
			modelAndView.addObject("mailSharedUsers", mailSharedUsers);
			modelAndView.addObject("mailItems", mailItems);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

}
