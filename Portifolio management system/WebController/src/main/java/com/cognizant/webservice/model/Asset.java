package com.cognizant.webservice.model;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Asset {
	
	
	private int tid;
	
	private String assetid;
	
	private int portfolioid;
	
	private String type;
	
	private int units;

	
	
	
	
	
	
}
