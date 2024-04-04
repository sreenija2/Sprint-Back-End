package com.digitalgoldwallet.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("Validation failed");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		return responseEntyity;
	}
	
	@ExceptionHandler(InvalidUserIDException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidUserIDException(InvalidUserIDException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("Validation failed");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		return responseEntyity;
	}
	
	@ExceptionHandler(InvalidAddressIDException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidAddressIDException(InvalidAddressIDException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("Validation failed");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		return responseEntity;
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleAddressNotFoundException(AddressNotFoundException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("Validation failed");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		return responseEntity;
	}
	
	@ExceptionHandler(DuplicateAddressIDException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateAddressIDException(DuplicateAddressIDException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("Validation failed");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		return responseEntity;
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
	

}
