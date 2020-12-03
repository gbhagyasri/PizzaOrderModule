package com.onlinepizza.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
	@ExceptionHandler(value = OrderIdNotFoundException.class)
	public ResponseEntity<Object> handleOrderIdNotFoundException(OrderIdNotFoundException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = PizzaIdNotFoundException.class)
	public ResponseEntity<Object> handlePizzaIdNotFoundException(PizzaIdNotFoundException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = CoupanIdNotFoundException.class)
	public ResponseEntity<Object> handleCoupanIdNotFoundException(CoupanIdNotFoundException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = CustomerIdNotFoundException.class)
	public ResponseEntity<Object> handleCustomerIdNotFoundException(CustomerIdNotFoundException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = UserIdNotFoundException.class)
	public ResponseEntity<Object> handleUserIdNotFoundException(UserIdNotFoundException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InvalidMinCostMaxCostException.class)
	public ResponseEntity<Object> handleInvalidMinCostMaxCostException(InvalidMinCostMaxCostException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InvalidCoupanOperationException.class)
	public ResponseEntity<Object> handleInvalidCoupanOperationException(InvalidCoupanOperationException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InvalidSizeException.class)
	public ResponseEntity<Object> handleInvalidSizeException(InvalidSizeException exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}


}
