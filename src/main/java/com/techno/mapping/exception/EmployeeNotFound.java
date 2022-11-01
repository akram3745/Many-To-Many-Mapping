package com.techno.mapping.exception;

public class EmployeeNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String msg){
		super(msg);
	}
}
