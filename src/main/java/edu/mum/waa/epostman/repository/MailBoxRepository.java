package edu.mum.waa.epostman.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.MailBox;

@Repository
public interface MailBoxRepository extends CrudRepository<MailBox, Long> {

	@Query("SELECT m FROM MailBox m WHERE m.mNumber=:mNumber")
	MailBox findMailBoxByNumber(@Param("mNumber") Integer key);
}
