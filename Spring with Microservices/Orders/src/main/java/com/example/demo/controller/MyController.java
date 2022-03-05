package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/orders")
public class MyController {

	@Value("${name}")
	String name;

	@GetMapping("/all")
	public String getName() {
		return "This is All orders API from Orders Microservice";
	}
	
	@GetMapping("/order/{id}")
	public String getAge(@PathVariable("id") int id) {
		return "Order ID is : "+id+" from "+this.name;
	}
}
