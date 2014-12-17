package edu.mum.waa.epostman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.MailBox;
import edu.mum.waa.epostman.service.MailBoxService;

@Controller
@RequestMapping(value = "/mailBox")
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
		return modelAndView;
	}

	@RequestMapping(value = "/registerMailBox", method = RequestMethod.POST)
	public ModelAndView registerMailBox(
			@ModelAttribute("newMailBox") MailBox mailBox,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
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
			redirectAttributes.addFlashAttribute("responseMsg",
					"Mail Box registered Successfully.");
			return new ModelAndView("redirect:/mailBox");
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
}
