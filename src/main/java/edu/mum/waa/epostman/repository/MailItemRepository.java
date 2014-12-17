package edu.mum.waa.epostman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.MailItem;

@Repository
public interface MailItemRepository extends CrudRepository<MailItem, Long>{

}
