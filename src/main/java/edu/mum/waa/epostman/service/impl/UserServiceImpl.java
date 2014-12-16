package edu.mum.waa.epostman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.epostman.domain.User;
import edu.mum.waa.epostman.repository.UserRepository;
import edu.mum.waa.epostman.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		user.setStatus(0);
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public List<User> getRegisteredUsers() {
		return userRepository.getRegisteredUsers();
	}

	public User find(Long id) {
		return userRepository.findOne(id);
	}

	public User findUserByLoginId(String loginId) {
		return userRepository.findUserByLoginId(loginId);
	}

}
