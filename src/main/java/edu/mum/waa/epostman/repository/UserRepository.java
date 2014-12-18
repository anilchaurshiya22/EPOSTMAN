package edu.mum.waa.epostman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findUserByLoginId(@Param("username") String key);

	@Query("SELECT u FROM User u WHERE u.email=:email")
	User findUserByEmail(@Param("email") String key);

	@Query("SELECT u FROM User u WHERE u.role=1")
	List<User> getRegisteredUsers();

	@Query("select u from User u where u.mailBox.id=:mboxId")
	List<User> getAllUserByMailBoxId(@Param("mboxId") Long mboxId);

}
