package com.zbank.retail.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zbank.retail.exception.EmployingOrganizationNotFoundException;

@ControllerAdvice
public class EmployingOrganizationNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(EmployingOrganizationNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String empOrgNotFoundHandler(EmployingOrganizationNotFoundException ex) {
    return ex.getMessage();
  }
}