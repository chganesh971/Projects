package com.cognizant.auth.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.auth.model.UserData;
import com.cognizant.auth.repository.UserRepository;



@Service
public class AdminDetailsService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDetailsService.class);

	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		LOGGER.debug("Start : {}", "loadUserByUsername");
		UserData custuser = userRepository.findById(uid).orElse(null);
		LOGGER.debug("End : {}", "loadUserByUsername");
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
	}

}
