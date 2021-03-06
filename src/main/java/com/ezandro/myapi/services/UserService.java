package com.ezandro.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezandro.myapi.entities.User;
import com.ezandro.myapi.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

}
