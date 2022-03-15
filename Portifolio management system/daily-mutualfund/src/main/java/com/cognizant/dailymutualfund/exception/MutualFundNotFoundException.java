package com.cognizant.dailymutualfund.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MutualFundNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MutualFundNotFoundException(String message)
	{
		super(message);
	}
}
