package edu.mum.waa.epostman.service;

import java.util.List;

import edu.mum.waa.epostman.domain.MailBox;

public interface MailBoxService {
	MailBox registerMailBox(MailBox mailBox);

	MailBox findMailBoxByNumber(Integer mNumber);

	List<MailBox> getAllMailBoxes();
}
