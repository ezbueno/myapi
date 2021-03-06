package com.ezandro.myapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezandro.myapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
