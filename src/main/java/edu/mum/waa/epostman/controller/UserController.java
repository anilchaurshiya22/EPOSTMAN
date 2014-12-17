package edu.mum.waa.epostman.controller;

import javax.servlet.http.HttpServletRequest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.domain.UserStatus;
import edu.mum.waa.epostman.service.MailBoxService;
import edu.mum.waa.epostman.service.UserService;
import edu.mum.waa.epostman.validator.PasswordValidator;

@Controller
@RequestMapping(value = "")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailBoxService mailBoxService;
	
	@Autowired
	PasswordValidator passwordValidator;

	private ModelAndView modelAndView;

	public UserController() {
		modelAndView = new ModelAndView("layouts/main");
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView showDashboard() {
		modelAndView.addObject("partials", "user/dashboard");
		return modelAndView;

	}

	@RequestMapping(value = "/users")
	public ModelAndView getAllUser(Model model) {
		modelAndView.addObject("users", userService.getRegisteredUsers());
		modelAndView.addObject("partials", "user/user-list");
		return modelAndView;
	}

	@RequestMapping(value = "/a/adduser")
	public String getAddUser(Model model) {
		return "add-user";

	}

	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register-form";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String pocessRegister(@ModelAttribute("user") @Valid User newUser,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "register-form";
		}
		User user = userService.saveUser(newUser);
		if (user != null) {
			return "redirect:/register-success";
		} else {
			model.addAttribute("message", "Sorry!!! Problem Occured in User Registration.");
			return "register-form";
		}
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public String changePassword(@ModelAttribute("user")User newUser){		
		return "change-password";		
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("user") @Valid User newUser,
			BindingResult result, RedirectAttributes redirectAttr,HttpServletRequest request){	
		User user=(User) request.getSession().getAttribute("authenitcatedUser");
		newUser.setId(user.getId());
		passwordValidator.validate(newUser, result);		
		if (result.hasErrors()) {			
			return "change-password";
		}
		userService.changePassword(newUser);
		redirectAttr.addFlashAttribute("message", "Password Change Successfully!!!");
		//redirectAttr.addFlashAttribute("user", newUser);
		return "redirect:/userProfile";		
	}
	
	@RequestMapping(value="/userProfile")
	public String userProfile(){		
		return "user-profile";

		
	}

	@RequestMapping("/register-success")
	public String registerSuccessPage() {
		return "register-success";
	}
	

	@RequestMapping(value = "/user/edit/{id}", method=RequestMethod.GET)
	public ModelAndView updatePage(@PathVariable("id") String id) {
		Long userId = Long.parseLong(id);
		modelAndView.addObject("user", userService.find(userId));
		modelAndView.addObject("partials", "user/edit-form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/edit/{id}", method=RequestMethod.POST)
	public ModelAndView pocessUpdate(@PathVariable("id") String id, @ModelAttribute("user") @Valid User editUser,
			BindingResult result) {

		if (result.hasErrors()) {
			modelAndView.addObject("partials", "user/edit-form");
			return modelAndView;
		}

		Long userId = Long.parseLong(id);
		User oldUser = userService.find(userId);
		oldUser.setFirstName(editUser.getFirstName());
		oldUser.setLastName(editUser.getLastName());
		oldUser.setGender(editUser.getGender());
		oldUser.setEmail(editUser.getEmail());
		oldUser.setContactNumber(editUser.getContactNumber());
		oldUser.setDescription(editUser.getDescription());
		User user = userService.saveUser(oldUser);
		if (user != null) {
			return new ModelAndView("redirect:/users");
		} else {
			modelAndView.addObject("message", "Sorry!!! Problem Occured in User Edit.");
			modelAndView.addObject("partials", "user/edit-form");
			return modelAndView;
		}
	}

	@RequestMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") String id, final RedirectAttributes ra) {
		Long userId = Long.parseLong(id);
		if(userService.find(userId) != null) {
			userService.deleteUser(userId);
			ra.addFlashAttribute("successMessage", "User Deleted Successfully");
		}
		return "redirect:/users";
	}


	@RequestMapping(value = "/enable-user/{id}", method=RequestMethod.GET)
	public ModelAndView enableUserPage(@PathVariable("id") String id) {
		Long userId = Long.parseLong(id);
		modelAndView.addObject("user", userService.find(userId));
		modelAndView.addObject("mailboxes", mailBoxService.getAllMailBoxes());
		modelAndView.addObject("partials", "user/enableUser");
		return modelAndView;
	}
	
	@RequestMapping(value = "/enable-user/{id}", method=RequestMethod.POST)
	public ModelAndView pocessEnableUser(@PathVariable("id") String id, @ModelAttribute("user") @Valid User editUser,
			BindingResult result) {
		if (result.hasErrors()) {
			modelAndView.addObject("partials", "user/enableUser");
			return modelAndView;
		}

		Long userId = Long.parseLong(id);
		User oldUser = userService.find(userId);
		oldUser.setMailBox(editUser.getMailBox());
		oldUser.setStatus(UserStatus.Active);
		User user = userService.saveUser(oldUser);
		if (user != null) {
			return new ModelAndView("redirect:/users");
		} else {
			modelAndView.addObject("message", "Sorry!!! Problem Occured while enabling User.");
			modelAndView.addObject("partials", "user/enableUser");
			return modelAndView;
		}
	}
	
	@RequestMapping("/disable-user/{id}")
	public String pocessDisableUser(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		Long userId = Long.parseLong(id);
		User oldUser = userService.find(userId);
		oldUser.setMailBox(null);
		oldUser.setStatus(UserStatus.Blocked);
		User user = userService.saveUser(oldUser);
		if (user == null) {
			redirectAttributes.addFlashAttribute("errorMessage", "Sorry!!! Problem Occured while enabling User.");
		}
		return "redirect:/users";
	}

}
