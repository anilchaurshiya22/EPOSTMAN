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

	public MailBox registerMailBox(MailBox mailBox) {
		return mailBoxRepository.save(mailBox);
	}

	public MailBox findMailBoxByNumber(Integer mNumber) {
		return mailBoxRepository.findMailBoxByNumber(mNumber);
	}

	public List<MailBox> getAllMailBoxes() {
		return (List<MailBox>) mailBoxRepository.findAll();
	}

	public MailBox findMailBoxById(Long id) {
		return mailBoxRepository.findOne(id);
	}

	public void deleteUser(long id) {
		mailBoxRepository.delete(id);
	}

}
