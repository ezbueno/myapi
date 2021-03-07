package com.ezandro.myapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ezandro.myapi.entities.User;
import com.ezandro.myapi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		User newUser = userService.update(id, user);
		return ResponseEntity.ok().body(newUser);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User newUser = userService.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
