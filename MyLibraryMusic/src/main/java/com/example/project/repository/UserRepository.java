package com.example.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.project.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	//List<User>findByTrackId(int trackId);
	public User findByFirstnameAndLastname(String firstname, String lastname);
	
	public User findByUsernameAndPassword(String username, String password);
	}

