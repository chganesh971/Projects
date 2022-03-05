package com.email.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/email")
public class EmailController {

	@GetMapping("/post/{content}")
	public String ProcessEmail(@PathVariable("content") String content) {
		System.out.println("Email request processed..");
		return "Message Successfully sent to "+content+"!";
	}
	
}
