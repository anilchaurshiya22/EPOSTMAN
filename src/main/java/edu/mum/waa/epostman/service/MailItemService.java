package edu.mum.waa.epostman.service;

import java.util.List;

import edu.mum.waa.epostman.domain.MailItem;

public interface MailItemService {

	MailItem saveMailItem(MailItem mailItem);

	List<MailItem> findAll();

	MailItem find(Long id);

	void delete(Long id);

	List<MailItem> getAllMailItemByUserId(Long userId);
}
