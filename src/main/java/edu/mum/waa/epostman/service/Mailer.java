package edu.mum.waa.epostman.service;

public interface Mailer {

	void send(String from, String[] to, String subject, String myMessage);
}
