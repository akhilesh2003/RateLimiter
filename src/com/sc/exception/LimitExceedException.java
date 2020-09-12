package com.sc.exception;

public class LimitExceedException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Custom exception for more meaningful message and logging purpose
	 */
	public LimitExceedException(String message){
		super(message);
	}
	
}
