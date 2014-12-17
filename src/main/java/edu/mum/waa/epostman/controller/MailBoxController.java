package edu.mum.waa.epostman.controller;

import java.util.List;

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

import edu.mum.waa.epostman.domain.MailBox;
import edu.mum.waa.epostman.service.MailBoxService;

@Controller
@RequestMapping(value = "/a/mailBox")
public class MailBoxController {

	@Autowired
	private MailBoxService mailBoxService;
	private ModelAndView modelAndView;

	public MailBoxController() {
		modelAndView = new ModelAndView("layouts/main");
	}

	@RequestMapping(value = "/addMailBox")
	public ModelAndView getMailBoxForm(
			@ModelAttribute("newMailBox") MailBox mailBox, Model model) {
		modelAndView.addObject("partials", "mailBox/registerMailBox");
		modelAndView.addObject("responseMsg", "");
		return modelAndView;
	}

	@RequestMapping(value = "/registerMailBox", method = RequestMethod.POST)
	public ModelAndView registerMailBox(
			@ModelAttribute("newMailBox") @Valid MailBox mailBox,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		mailBox.setStatus("Y");

		if (result.hasErrors()) {

			modelAndView.addObject("partials", "mailBox/registerMailBox");
			return modelAndView;
		}
		if (mailBoxService.findMailBoxByNumber(mailBox.getmNumber()) != null) {
			modelAndView.addObject("responseMsg",
					"Mail Box already registered with this number.");
			modelAndView.addObject("partials", "mailBox/registerMailBox");
			return modelAndView;
		}
		if (mailBoxService.registerMailBox(mailBox) != null) {
			redirectAttributes.addFlashAttribute("successMsg",
					"Mail Box registered Successfully.");
			return new ModelAndView("redirect:/a/mailBox");
		} else {
			model.addAttribute("responseMsg", "Sorry!!! Something went wrong.");
			modelAndView.addObject("partials", "mailBox/registerMailBox");
			return modelAndView;
		}
	}

	@RequestMapping
	public ModelAndView getAllMailBoxes(Model model) {
		List<MailBox> mailBoxs = mailBoxService.getAllMailBoxes();
		modelAndView.addObject("mailBoxesList", mailBoxs);
		modelAndView.addObject("partials", "mailBox/mailBoxesList");
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updatePage(@PathVariable("id") String id) {
		Long mailBoxId = Long.parseLong(id);
		modelAndView.addObject("mailBox",
				mailBoxService.findMailBoxById(mailBoxId));
		modelAndView.addObject("partials", "mailBox/edit-form");
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView pocessUpdate(@PathVariable("id") String id,
			@ModelAttribute("mailBox") @Valid MailBox editMailBox,
			BindingResult result) {

		if (result.hasErrors()) {
			modelAndView.addObject("partials", "mailBox/edit-form");
			return modelAndView;
		}

		Long userId = Long.parseLong(id);
		MailBox mailBox = mailBoxService.findMailBoxById(userId);
		mailBox.setCode(editMailBox.getCode());
		mailBox.setmNumber(editMailBox.getmNumber());
		mailBox.setStatus(editMailBox.getStatus());
		MailBox mBox = mailBoxService.registerMailBox(mailBox);
		if (mBox != null) {
			return new ModelAndView("redirect:/a/mailBox");
		} else {
			modelAndView.addObject("message",
					"Sorry!!! Problem Occured in Mail Box Edit.");
			modelAndView.addObject("partials", "mailBox/edit-form");
			return modelAndView;
		}
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String id,
			final RedirectAttributes ra) {
		Long userId = Long.parseLong(id);
		if (mailBoxService.findMailBoxById(userId) != null) {
			mailBoxService.deleteUser(userId);
			ra.addFlashAttribute("successMsg", "User Deleted Successfully");
		}
		return "redirect:/a/mailBox";
	}

}
