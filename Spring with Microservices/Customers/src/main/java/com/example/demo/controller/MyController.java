package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/customers")
public class MyController {

	@Value("${name2}")
	String name;

	@GetMapping("/all")
	public String getName() {
		return "This is All Customers API from Customers Microservice";
	}
	
	@GetMapping("/customer/{id}")
	public String getAge(@PathVariable("id") int id) {
		return "Customer ID is : "+id+" from "+this.name;
	}
}
