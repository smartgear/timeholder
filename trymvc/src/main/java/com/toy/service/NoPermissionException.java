package com.toy.service;

public class NoPermissionException extends ToyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPermissionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NoPermissionException(String message) {
		super(message);
	}
	
	public NoPermissionException(Throwable cause) {
		super(cause);
	}
}
