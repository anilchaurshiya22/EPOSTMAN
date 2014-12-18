package edu.mum.waa.epostman.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.epostman.domain.MailBox;
import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.domain.UserStatus;
import edu.mum.waa.epostman.service.MailBoxService;
import edu.mum.waa.epostman.service.Mailer;
import edu.mum.waa.epostman.service.UserService;
import edu.mum.waa.epostman.service.impl.GmailMailer;
import edu.mum.waa.epostman.util.SecurityUtil;
import edu.mum.waa.epostman.validator.PasswordValidator;

@Controller
@RequestMapping(value = "/u")
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

	@RequestMapping(value = "/users")
	public ModelAndView getAllUser(Model model) {
		modelAndView.addObject("users", userService.getRegisteredUsers());
		modelAndView.addObject("partials", "user/user-list");
		return modelAndView;
	}	

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("user") User newUser) {
		modelAndView.addObject("partials", "user/change-password");
		return modelAndView;

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("user") @Valid User newUser,
			BindingResult result, RedirectAttributes redirectAttr) {
		User user = SecurityUtil.getSessionUser();
		newUser.setId(user.getId());
		passwordValidator.validate(newUser, result);
		if (result.hasErrors()) {
			return "/changePassword";
		}
		userService.changePassword(newUser);
		redirectAttr.addFlashAttribute("message",
				"Password Change Successfully!!!");
		// redirectAttr.addFlashAttribute("user", newUser);
		return "redirect:/u/settings";
	}

	@RequestMapping("/register-success")
	public String registerSuccessPage() {
		return "register-success";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updatePage(@PathVariable("id") String id) {
		Long userId = Long.parseLong(id);
		modelAndView.addObject("user", userService.find(userId));
		modelAndView.addObject("partials", "user/edit-form");
		return modelAndView;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public ModelAndView pocessUpdate(@PathVariable("id") String id,
			@ModelAttribute("user") @Valid User editUser, BindingResult result) {

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
			return new ModelAndView("redirect:/u/users");
		} else {
			modelAndView.addObject("message",
					"Sorry!!! Problem Occured in User Edit.");
			modelAndView.addObject("partials", "user/edit-form");
			return modelAndView;
		}
	}

	@RequestMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") String id,
			final RedirectAttributes ra) {
		Long userId = Long.parseLong(id);
		if (userService.find(userId) != null) {
			userService.deleteUser(userId);
			ra.addFlashAttribute("successMessage", "User Deleted Successfully");
		}
		return "redirect:/users";
	}

	@RequestMapping("/settings")
	public ModelAndView userProfile() {
		User user = SecurityUtil.getSessionUser();
		modelAndView.addObject("user", user);
		modelAndView.addObject("partials", "user/user-profile");
		return modelAndView;
	}

	@RequestMapping("/userProfile")
	public ModelAndView redirectUserProfile() {
		modelAndView.addObject("partials", "user/user-profile");
		return modelAndView;
	}

	@RequestMapping(value = "/enable-user/{id}", method = RequestMethod.GET)
	public ModelAndView enableUserPage(@PathVariable("id") String id) {
		Long userId = Long.parseLong(id);
		modelAndView.addObject("user", userService.find(userId));
		modelAndView.addObject("mailboxes", mailBoxService.getAllMailBoxes());
		modelAndView.addObject("partials", "user/enableUser");
		return modelAndView;
	}

	@RequestMapping(value = "/enable-user/{id}", method = RequestMethod.POST)
	public ModelAndView pocessEnableUser(@PathVariable("id") String id,
			@ModelAttribute("user") @Valid User editUser, BindingResult result) {
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
			Mailer mailer = new GmailMailer("epostman.devdevil@gmail.com",
					"dev@devil");
			
			String lockCode = user.getMailBox().getCode();
			String[] splitCode = lockCode.split("-");
			String instruction = String.format("1. Turn anti-clockwise atleast 5 round and stop at %s.\n2. Turn clockwise passing atleast one time and stop at %s.\n3. Turn anti-clockise and stop at %s.\n4. You will hear a sound then Open it.", splitCode[0], splitCode[1], splitCode[2]);
			
			String myMessage = String
					.format("Hi %s,\nYour E-PostMan Account has been activated.\nYour Mail Box Number is %d\nYour MailBox Lock Combination is %s\nInstruction:\n" + instruction + "\n\nThank You,\nE-MailBox Team",
							user, user.getMailBox().getmNumber(), lockCode);
			String[] to = { oldUser.getEmail() };
			mailer.send("epostman.devdevil@gmail.com", to,
					"E-PostMan: Your account is activated.", myMessage);
			return new ModelAndView("redirect:/u/users");
		} else {
			modelAndView.addObject("message",
					"Sorry!!! Problem Occured while enabling User.");
			modelAndView.addObject("partials", "user/enableUser");
			return modelAndView;
		}
	}

	@RequestMapping("/disable-user/{id}")
	public String pocessDisableUser(@PathVariable("id") String id,
			RedirectAttributes redirectAttributes) {
		Long userId = Long.parseLong(id);
		User oldUser = userService.find(userId);
		oldUser.setMailBox(null);
		oldUser.setStatus(UserStatus.Blocked);
		User user = userService.saveUser(oldUser);
		if (user == null) {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Sorry!!! Problem Occured while enabling User.");
		}
		return "redirect:/u/users";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadPhoto")
	public String uploadPersonPhoto(@ModelAttribute("user") User user,
			HttpServletRequest request, RedirectAttributes model)
			throws FileUploadException, IOException {
		File uploadedFile = null;
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");
		MultipartFile image = user.getProfilePic();
		if (image != null && !image.isEmpty()) {
			try {
				uploadedFile = new File(rootDirectory + "\\resources\\images\\"
						+ user.getId() + ".png");
				image.transferTo(uploadedFile);
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		User newUser = userService.find(user.getId());
		newUser.setPicLocation("/resource/images/" + newUser.getId() + ".png");
		userService.saveUser(newUser);
		model.addFlashAttribute("user", newUser);
		model.addFlashAttribute("message", "Uploaded Successfully");
		return "redirect:/u/userProfile";
	}

}
