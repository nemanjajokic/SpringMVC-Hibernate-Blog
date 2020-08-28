package com.mvc.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mvc.dao.Repository;
import com.mvc.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Repository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Error 404");
		}
		
		return new UserDetailsImpl(user);
	}
	
}
