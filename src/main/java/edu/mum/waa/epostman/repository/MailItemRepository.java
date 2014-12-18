package edu.mum.waa.epostman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.MailItem;

@Repository
public interface MailItemRepository extends CrudRepository<MailItem, Long>{

	@Query("select m from MailItem m where m.user.id=:userId")
	List<MailItem> getAllMailItems(@Param("userId") Long userId);
}
