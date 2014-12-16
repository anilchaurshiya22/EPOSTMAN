package edu.mum.waa.epostman.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findUserByLoginId(@Param("username") String key);

}