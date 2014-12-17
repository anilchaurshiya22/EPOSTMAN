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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.ItemType;
import edu.mum.waa.epostman.domain.MailItem;
import edu.mum.waa.epostman.service.MailItemService;
import edu.mum.waa.epostman.service.UserService;

@Controller()
@RequestMapping(value="/a/mails")
public class MailItemController {
	
	private ModelAndView modelAndView;
	@Autowired
	UserService userService;
	
	@Autowired
	MailItemService mailItemService;
	
	public MailItemController() {
		modelAndView = new ModelAndView("layouts/main");
	}	

	@RequestMapping(value = "/")
	public ModelAndView getAllMailItems(Model model) {			
		modelAndView.addObject("mailitems",mailItemService.findAll());
		modelAndView.addObject("partials", "mailItem/mailitems-list");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerMailItem(@ModelAttribute("mailitem" ) MailItem mailitem ,Model model) {
		modelAndView.addObject("users", userService.getRegisteredUsers());	
		modelAndView.addObject("partials", "mailItem/mailitem-form");
		modelAndView.addObject("mailTypes", ItemType.getAllItemType());
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String pocessRegister(@ModelAttribute("mailitem") @Valid MailItem newMailItem,
			BindingResult result, Model model,RedirectAttributes redirectAttr) {
		MailItem mailitem=null;
		newMailItem.setItemType(newMailItem.getType()==0?ItemType.Pickable:ItemType.NonPickable);
		if (result.hasErrors()) {
			return "mailitem-form";
		}
		try{
		 mailitem = mailItemService.saveMailItem(newMailItem);
		}catch(Exception ex){
			System.out.println("ex"+ ex.getStackTrace());
		}
		if (mailitem != null) {
			redirectAttr.addFlashAttribute("mailitem",mailitem);
			return "redirect:/a/mails/";
		} else {
			model.addAttribute("message",
					"Sorry!!! Problem Occured in User Registration.");
			return "mailitem-form";
		}
		
	}
	
	@RequestMapping("/register-success")
	public String registerSuccessPage() {
		return "register-success";
	}
}
