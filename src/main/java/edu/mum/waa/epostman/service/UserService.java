package edu.mum.waa.epostman.service;

import java.util.List;

import edu.mum.waa.epostman.domain.User;

public interface UserService {

	User registerUser(User user);
	
	List<User> findAll();
	
	List<User> getRegisteredUsers();
	
	User find(Long id);
	
	User findUserByLoginId(String loginId);
}
