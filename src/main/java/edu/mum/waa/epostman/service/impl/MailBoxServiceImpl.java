package edu.mum.waa.epostman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.epostman.domain.MailBox;
import edu.mum.waa.epostman.repository.MailBoxRepository;
import edu.mum.waa.epostman.service.MailBoxService;

@Transactional
@Service
public class MailBoxServiceImpl implements MailBoxService {

	@Autowired
	private MailBoxRepository mailBoxRepository;

	@Override
	public MailBox registerMailBox(MailBox mailBox) {
		mailBox.setStatus(new Character('Y'));
		return mailBoxRepository.save(mailBox);
	}

	@Override
	public MailBox findMailBoxByNumber(Integer mNumber) {
		return mailBoxRepository.findMailBoxByNumber(mNumber);
	}

	@Override
	public List<MailBox> getAllMailBoxes() {
		return (List<MailBox>) mailBoxRepository.findAll();
	}

}
