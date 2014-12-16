package edu.mum.waa.epostman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.MailBox;
import edu.mum.waa.epostman.service.MailBoxService;

@Controller
@RequestMapping(value = "/mailBox")
public class MailBoxController {

	@Autowired
	private MailBoxService mailBoxService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMailBoxForm(@ModelAttribute("newMailBox") MailBox mailBox,
			BindingResult result, Model model,
			@ModelAttribute("mapping1Form") final Object mapping1FormObject) {
		return "registerMailBox";
	}

	@RequestMapping(value = "/registerMailBox", method = RequestMethod.POST)
	public String registerMailBox(
			@ModelAttribute("newMailBox") MailBox mailBox,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "/registerMailBox";
		}
		if (mailBoxService.findMailBoxByNumber(mailBox.getmNumber()) != null) {
			model.addAttribute("responseMsg",
					"Mail Box already registered with this number.");
			return "registerMailBox";
		}
		if (mailBoxService.registerMailBox(mailBox) != null) {
			redirectAttributes.addFlashAttribute("responseMsg",
					"Mail Box registered Successfully.");
			return "redirect:/mailBox/mailBoxesList";
		} else {
			model.addAttribute("responseMsg", "Sorry!!! Something went wrong.");
			return "registerMailBox";
		}
	}

	@RequestMapping(value = "/mailBoxesList")
	public String getAllMailBoxes(Model model) {
		List<MailBox> mailBoxs = mailBoxService.getAllMailBoxes();
		model.addAttribute("mailBoxesList", mailBoxs);
		return "mailBoxesList";
	}
}
