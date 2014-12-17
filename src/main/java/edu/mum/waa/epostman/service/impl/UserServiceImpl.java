package edu.mum.waa.epostman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.epostman.domain.Role;
import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.domain.UserStatus;
import edu.mum.waa.epostman.repository.UserRepository;
import edu.mum.waa.epostman.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		user.setStatus(UserStatus.Blocked);
		user.setRole(Role.User);
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public User find(Long id) {
		return userRepository.findOne(id);
	}

	public User findUserByLoginId(String loginId) {
		return userRepository.findUserByLoginId(loginId);
	}
	
	public User changePassword(User user){
		User newUser=find(user.getId());
		newUser.setLoginPassword(user.getLoginPassword());
		return userRepository.save(newUser);
		
		
	}

}
