package edu.mum.waa.epostman.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/a/email")
public class EmailController {
	@RequestMapping(value = "/feedback")
	public ModelAndView feedback() {
		ModelAndView modelAndView = new ModelAndView("feedback-form");
		return modelAndView;
	}

	@RequestMapping(value = "/feedback/process")
	public ModelAndView feedbackProdess(HttpServletRequest request,
			HttpServletResponse response) {
		final String username = "risal.deep@gmail.com";
		final String password = "aanidr123";

		String from = request.getParameter("from");
		String subject = request.getParameter("subject");
		String myMessage = request.getParameter("message");
		subject = "Item Notification: " + subject;
		myMessage = "Sender id: " + from + "\n\n" + myMessage;
		String to[] = { "risal.deep@gmail.com", "syraz37@gmail.com"};
		String cc[] = { "keithaniz@gmail.com"};
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				addressTo[i] = new InternetAddress(to[i]);
			}
			message.setRecipients(RecipientType.TO, addressTo);

			InternetAddress[] addressCC = new InternetAddress[cc.length];
			for (int i = 0; i < cc.length; i++) {
				addressCC[i] = new InternetAddress(cc[i]);
			}
			message.setRecipients(RecipientType.CC, addressCC);

			message.setSubject(subject);
			message.setText(myMessage);

			Transport.send(message);

			System.out.println("Feedback Successfully Sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		ModelAndView modelAndView = new ModelAndView("feedback-form");
		modelAndView.addObject("message", "Feedback Successfully Sent");

		return modelAndView;
	}
}
