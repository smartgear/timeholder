package com.toy.service;


public class ToyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ToyException(String message) {
		super(message);
	}
	
	public ToyException(Throwable cause) {
		super(cause);
	}

}
