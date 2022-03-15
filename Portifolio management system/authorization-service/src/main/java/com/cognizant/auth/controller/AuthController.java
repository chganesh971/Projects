package com.cognizant.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auth.model.AuthResponse;
import com.cognizant.auth.model.UserData;
import com.cognizant.auth.repository.UserRepository;
import com.cognizant.auth.service.AdminDetailsService;
import com.cognizant.auth.service.JwtUtil;

/**
 * This class is having all the endpoints related to authorization purpose. For
 * getting the token and validating the token this class will be used.
 */

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);


	@Autowired
	private JwtUtil jwtutil;

	private final static String LOGIN = "login";
	
	@Autowired
	private AdminDetailsService adminDetailService;

	@Autowired
	private UserRepository userRepository;


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserData userlogincredentials) {
		LOGGER.debug("Start : {}", LOGIN);
		final UserDetails userdetails = adminDetailService.loadUserByUsername(userlogincredentials.getUserid());
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			LOGGER.debug("End : {}", LOGIN);
			
			return new ResponseEntity<>(new UserData(userlogincredentials.getUserid(), null, null, jwtutil.generateToken(userdetails)),HttpStatus.OK);
			
			
		} else {
			LOGGER.debug("Access Denied : {}", LOGIN);
			return new ResponseEntity<>("Invalid Username or Password", HttpStatus.FORBIDDEN);
		}
	}


	@GetMapping("/validate") 
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) { //Bearer token
		LOGGER.debug("Start : {}", "getValidity");
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
			res.setName((userRepository.findById(jwtutil.extractUsername(token)).orElse(null).getUname()));

		} else {
			res.setValid(false);
		}
		LOGGER.debug("End : {}", "getValidity");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}













