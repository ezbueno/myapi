package com.ezandro.myapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezandro.myapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
