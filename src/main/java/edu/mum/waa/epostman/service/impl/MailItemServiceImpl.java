package edu.mum.waa.epostman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.epostman.domain.MailItem;
import edu.mum.waa.epostman.repository.MailItemRepository;
import edu.mum.waa.epostman.service.MailItemService;

@Service
@Transactional
public class MailItemServiceImpl implements MailItemService {

	@Autowired
	MailItemRepository mailItemRepo;

	public MailItem saveMailItem(MailItem mailItem) {
		return mailItemRepo.save(mailItem);
	}

	public List<MailItem> findAll() {
		return (List<MailItem>) mailItemRepo.findAll();
	}

	public MailItem find(Long id) {

		return mailItemRepo.findOne(id);
	}

	public void delete(Long id) {
		mailItemRepo.delete(id);

	}

	public List<MailItem> getAllMailItemByUserId(Long userId) {
		return mailItemRepo.getAllMailItems(userId);
	}

}
