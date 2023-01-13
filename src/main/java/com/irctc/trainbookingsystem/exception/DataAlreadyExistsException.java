package com.irctc.trainbookingsystem.exception;

import org.springframework.beans.factory.config.RuntimeBeanNameReference;

public class DataAlreadyExistsException extends RuntimeException{

	public DataAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
