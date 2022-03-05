package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

	@GetMapping("/userfallback")
	public String getFallback() {
		return "temporarily down..........";
	}

}
