package com.example.springmvcboot;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.springmvcboot.model.User;
import com.example.springmvcboot.model.UserPrincipal;
import com.example.springmvcboot.repo.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByUsername(username);
		if(user==null) {
			System.out.println("User not found.");
			
			throw new UsernameNotFoundException("User not found.");
		}
		return new UserPrincipal(user);
	}

}
