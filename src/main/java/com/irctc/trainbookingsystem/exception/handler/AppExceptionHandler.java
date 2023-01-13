package com.irctc.trainbookingsystem.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irctc.trainbookingsystem.exception.DataAlreadyExistsException;
import com.irctc.trainbookingsystem.exception.MinimunDataRequiredException;
import com.irctc.trainbookingsystem.exception.NoDataPresentException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(NoDataPresentException.class)
	public ResponseEntity<?> NoDataPresentExceptionHandler(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
	}
	
	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<?> DataAlreadyExistsException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
	}
	@ExceptionHandler(MinimunDataRequiredException.class)
	public ResponseEntity<?> MinimunDataRequiredExceptionHandler(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
	}
	
}
