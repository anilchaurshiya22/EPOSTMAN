package edu.mum.waa.epostman.service;

import java.util.List;

import edu.mum.waa.epostman.domain.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAll();

	List<User> getRegisteredUsers();

	User find(Long id);

	User findUserByLoginId(String loginId);

	User changePassword(User user);

	void deleteUser(long id);

	List<User> getAllUserByMailBoxId(Long mboxId);
}
