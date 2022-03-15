package com.cognizant.webservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

	
	private String userid;
	
	private String upassword;
	
	private String uname;
	
	private String authToken;

}
