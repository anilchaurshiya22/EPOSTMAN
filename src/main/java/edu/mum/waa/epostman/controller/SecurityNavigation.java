package edu.mum.waa.epostman.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.waa.epostman.domain.User;


@Controller
@SessionAttributes("authenitcatedUser")
public class SecurityNavigation {

	@RequestMapping(value = "/")
	public ModelAndView mainPage(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("authenitcatedUser");
		ModelAndView modelAndView=null;
		if(user!=null){			
			modelAndView =new ModelAndView("layouts/main");
			modelAndView.addObject("partials", "user/dashboard");
		}else{
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

	/*@RequestMapping(value = "/dashboard")
	public ModelAndView successLogin() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		User user=(User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		modelAndView.addObject("authenitcatedUser", user);
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView showDashboard() {
		ModelAndView modelAndView = new ModelAndView("layouts/main");
		modelAndView.addObject("partials", "user/dashboard");
		User user=(User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		modelAndView.addObject("authenitcatedUser", user);
		return modelAndView;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

}
