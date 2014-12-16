package edu.mum.waa.epostman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.service.UserService;

@Controller
@RequestMapping(value = "")
public class UserController {
	@Autowired
	private UserService userService;
	private String responseMessage;

	private ModelAndView modelAndView;

	public UserController() {
		modelAndView = new ModelAndView("layouts/main");
		modelAndView.addObject("abc", "cde");
	}

	@RequestMapping(value = "/u/alluser")
	public String getAllUser(Model model) {

		return "userlist";

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
		User user = userService.registerUser(newUser);
		if (user != null) {
			responseMessage = "User registered successfully.";
			return "partials/user/register-form";
		} else {
			responseMessage = "Sorry!!! Problem Occured in User Registration.";
			return "partials/user/register-form";
		}
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
