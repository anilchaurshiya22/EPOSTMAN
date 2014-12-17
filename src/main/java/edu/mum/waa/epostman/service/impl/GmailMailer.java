package edu.mum.waa.epostman.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import edu.mum.waa.epostman.service.Mailer;

public class GmailMailer implements Mailer {
	
	private String username;
	private String password;
	private final String smtpHost = "smtp.gmail.com";
	private final String smtpPort = "587";
	private final String smtpStarttls = "true";
	private final String smtpAuth = "true";
	
	
	
	public GmailMailer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void send(String from, String[] to, String subject, String myMessage) {
		
		String cc[] = {username};

		Properties props = new Properties();
		props.put("mail.smtp.auth", smtpAuth);
		props.put("mail.smtp.starttls.enable", smtpStarttls);
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
