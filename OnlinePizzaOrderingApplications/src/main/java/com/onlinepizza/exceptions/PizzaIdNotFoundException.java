package com.onlinepizza.exceptions;

public class PizzaIdNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PizzaIdNotFoundException(String message) {
		super(message);
	}
}
