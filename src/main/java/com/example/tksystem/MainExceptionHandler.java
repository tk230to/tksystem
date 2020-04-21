package com.example.tksystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> catchError(Exception exception) {
    return new ResponseEntity<String>("例外が発生しました。", null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
