package com.cg.onlinepizza.exceptions;

public class InvalidSizeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSizeException(String message) {
		super(message);
	}
}
