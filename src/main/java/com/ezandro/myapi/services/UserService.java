package com.ezandro.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezandro.myapi.entities.User;
import com.ezandro.myapi.repositories.UserRepository;
import com.ezandro.myapi.services.exceptions.UserNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User update(Integer id, User user) {
		User newUser = findById(id);
		newUser.setNome(user.getNome());
		newUser.setLogin(user.getLogin());
		newUser.setSenha(user.getSenha());
		return userRepository.save(newUser);
	}

	public User create(User user) {
		user.setId(null);
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		findById(id);
		userRepository.deleteById(id);
	}

}
