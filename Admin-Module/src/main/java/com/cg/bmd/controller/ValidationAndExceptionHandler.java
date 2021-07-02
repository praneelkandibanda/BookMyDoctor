package com.cg.bmd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.cg.bmd.entities.TreatmentException;
import com.cg.bmd.exception.AdminNotFoundException;
import com.cg.bmd.exception.AppointmentNotFoundException;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.exception.FeedbackNotFoundException;
import com.cg.bmd.exception.PatientNotFoundException;

@ControllerAdvice

public class ValidationAndExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> exception(AdminNotFoundException exception) {

		return new ResponseEntity<>("Admin Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = DoctorNotFoundException.class)
	public ResponseEntity<Object> exception(DoctorNotFoundException exception) {

		return new ResponseEntity<>("Doctor Not Found!!", HttpStatus.NOT_FOUND);

	}

	

	@ExceptionHandler(value = PatientNotFoundException.class)
	public ResponseEntity<Object> exception(PatientNotFoundException exception) {

		return new ResponseEntity<>("Patient Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(value = FeedbackNotFoundException.class)
	public ResponseEntity<Object> exception(FeedbackNotFoundException exception) {

		return new ResponseEntity<>("Feedback Not Found!!", HttpStatus.NOT_FOUND);

	}



	@ExceptionHandler (value = AppointmentNotFoundException.class)
	
	public ResponseEntity<Object> exception(AppointmentNotFoundException exception) {
		
		return new ResponseEntity<>("Appointment not Found",HttpStatus.BAD_REQUEST);
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
