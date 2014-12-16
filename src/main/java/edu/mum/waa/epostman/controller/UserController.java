package edu.mum.waa.epostman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class UserController {
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

	@RequestMapping(value = "/register")
	public String registerPage() {
		//modelAndView.addObject("partials", "user/register-form");
		return "register-form";
	}

}
