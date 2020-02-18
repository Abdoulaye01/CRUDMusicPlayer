package com.example.project.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
private final UserRepository userRepository;

public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
}
	
public void saveMyUser(User user) {
	userRepository.save(user);
}

public User findByFirstnameAndLastname(String firstname, String lastname) {
	return userRepository.findByFirstnameAndLastname(firstname, lastname);
}
	
public User findByUsernameAndPassword(String username, String password) {
	return userRepository.findByUsernameAndPassword(username,password);
}

}
