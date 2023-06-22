package com.zbank.retail.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zbank.retail.exception.EmployingOrganizationBadRequestFormatException;

@ControllerAdvice
public class EmployingOrganizationBadRequestFormatAdvice {

  @ResponseBody
  @ExceptionHandler(EmployingOrganizationBadRequestFormatException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String empOrgNotFoundHandler(EmployingOrganizationBadRequestFormatException ex) {
    return ex.getMessage();
  }
}