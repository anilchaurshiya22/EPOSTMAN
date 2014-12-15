package edu.mum.waa.epostman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class UserController {

	
	@RequestMapping(value="/u/alluser")
	public String getAllUser(Model model){
		
		return "userlist";
		
	}
	
	
	@RequestMapping(value="/a/adduser")
	public String getAddUser(Model model){		
		return "add-user";
		
	}
}
