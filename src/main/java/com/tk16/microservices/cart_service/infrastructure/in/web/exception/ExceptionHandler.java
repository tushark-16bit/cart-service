package com.tk16.microservices.cart_service.infrastructure.in.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    String finalMessage = "Total Errors: ".concat(String.valueOf(ex.getFieldErrorCount())) + "||";
    for (var message : ex.getFieldErrors()) {
      finalMessage =
          finalMessage.concat(message.getField() + ": " + message.getDefaultMessage()).concat("||");
    }
    ErrorDetails details =
        new ErrorDetails(LocalDateTime.now(), finalMessage, request.getDescription(true));
    return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(value =
          RuntimeException.class)
  protected ResponseEntity<Object> handleException(RuntimeException ex,
                                                   WebRequest request) {

    ErrorDetails details =
        new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(true));
    return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
  }
}
