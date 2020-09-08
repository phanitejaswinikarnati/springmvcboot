package com.example.springmvcboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmvcboot.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
}
