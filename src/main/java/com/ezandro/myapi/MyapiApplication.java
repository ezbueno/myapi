package com.ezandro.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ezandro.myapi.entities.User;
import com.ezandro.myapi.repositories.UserRepository;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Ezandro Bueno", "bueno", "123");
		User u2 = new User(null, "Nayara Balarotti", "nay", "123");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
