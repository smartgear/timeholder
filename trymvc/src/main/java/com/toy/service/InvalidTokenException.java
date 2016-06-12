package com.toy.service;

public class InvalidTokenException extends ToyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidTokenException(String message) {
		super(message);
	}
	
	public InvalidTokenException( Throwable cause) {
		super(cause);
	}

}
