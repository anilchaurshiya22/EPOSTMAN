package edu.mum.waa.epostman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.ItemType;
import edu.mum.waa.epostman.domain.MailItem;
import edu.mum.waa.epostman.domain.Status;
import edu.mum.waa.epostman.exception.CustomGenericException;
import edu.mum.waa.epostman.service.MailItemService;
import edu.mum.waa.epostman.service.Mailer;
import edu.mum.waa.epostman.service.UserService;
import edu.mum.waa.epostman.service.impl.GmailMailer;

@Controller()
@RequestMapping(value="/a/mails")
public class MailItemController {
	
	private ModelAndView modelAndView;
	private static boolean isEdit=false;
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
	@RequestMapping(value="/edit/{id}")
	public ModelAndView editMailItem(@PathVariable("id" ) Long id){
		modelAndView.addObject("mailitem", mailItemService.find(id));
		modelAndView.addObject("users", userService.getRegisteredUsers());	
		modelAndView.addObject("partials", "mailItem/mailitem-form");
		modelAndView.addObject("mailTypes", ItemType.getAllItemType());
		isEdit=true;
		modelAndView.addObject("isEdit", isEdit);		
		return modelAndView;		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerMailItem(@ModelAttribute("mailitem" ) MailItem mailitem) {		
		modelAndView.addObject("users", userService.getRegisteredUsers());	
		modelAndView.addObject("partials", "mailItem/mailitem-form");
		modelAndView.addObject("mailTypes", ItemType.getAllItemType());
		return modelAndView;
	}

	@RequestMapping(value = {"/register","/edit"}, method = RequestMethod.POST)
	public ModelAndView pocessRegister(@ModelAttribute("mailitem") @Valid MailItem newMailItem,
			BindingResult result, Model model,RedirectAttributes redirectAttr) {
		MailItem mailitem=null;
		newMailItem.setItemType(newMailItem.getType()==0?ItemType.Pickable:ItemType.NonPickable);
		newMailItem.setStatus(Status.Arrive);
		if (result.hasErrors()) {
			modelAndView.addObject("partials", "mailItem/mailitem-form");
			return modelAndView;
		}
		try{
		 mailitem = mailItemService.saveMailItem(newMailItem);
		}catch(Exception ex){
			System.out.println("ex"+ ex.getStackTrace());
		}
		if (mailitem != null) {
			redirectAttr.addFlashAttribute("mailitem",mailitem);
			return new ModelAndView("redirect:/a/mails/");
		} else {
			model.addAttribute("message",
					"Sorry!!! Problem Occured in User Registration.");
			return new ModelAndView("redirect:/register");
		}		
	}
		
	@RequestMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable("id") long id) {
		//MailItem mailitem = mailItemService.find(id);
		mailItemService.delete(id);
		return "redirect:/a/mails/";
	}
	
	@RequestMapping(value = "/notification/{id}")
	public ModelAndView pocessEnableUser(@PathVariable("id") long id, RedirectAttributes redirectAttr) {
		MailItem mailItem=mailItemService.find(id);
			try{
			Mailer mailer = new GmailMailer("epostman.devdevil@gmail.com",
					"dev@devil");			
			String myMessage = String
					.format("Hi %s,\n\nHurray!!! Your Item has arrived.\nPlease collect from MUM mail box center.\nYour Item Description are:\n Name : %s \n Description: %s \n ItemType: %s \n Date Of Arrival %s \n Barcode : %s \n\n\nThank You,\nE-MailBox Team",
							mailItem.getUser(), mailItem.getName(),mailItem.getDescription(), mailItem.getItemType().getName(),mailItem.getArrivalDate(),mailItem.getBarCode());
			String[] to = { mailItem.getUser().getEmail() };
			mailer.send("epostman.devdevil@gmail.com", to,
					"E-PostMan: Your account is activated.", myMessage);
			}catch(Exception ex){
				throw new CustomGenericException("Mail Not Send",ex.getMessage());
			}
			MailItem updateMailItem=mailItemService.find(id);
			updateMailItem.setStatus(Status.Notify);
			mailItemService.saveMailItem(updateMailItem);
			redirectAttr.addFlashAttribute("notified", true);
			return new ModelAndView("redirect:/a/mails/");		
	}


}
