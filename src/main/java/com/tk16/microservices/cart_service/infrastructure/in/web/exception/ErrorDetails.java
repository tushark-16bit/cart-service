package com.tk16.microservices.cart_service.infrastructure.in.web.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

  // date
  private LocalDateTime timestamp;
  // message
  private String message;
  // details
  private String details;

  public ErrorDetails(LocalDateTime timestamp, String message, String details) {
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
