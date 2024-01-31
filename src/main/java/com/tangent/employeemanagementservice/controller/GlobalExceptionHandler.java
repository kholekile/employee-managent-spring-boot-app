package com.tangent.employeemanagementservice.controller;

import com.tangent.employeemanagementservice.controller.response.ApiResponse;
import com.tangent.employeemanagementservice.controller.response.ValidationFailureResponse;
import com.tangent.employeemanagementservice.exception.EmployeeAddressDoesNotExistException;
import com.tangent.employeemanagementservice.exception.EmployeeDoesNotExistException;
import com.tangent.employeemanagementservice.exception.SkillDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ValidationFailureResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        final List<FieldError> fieldErrors = result.getFieldErrors();

        var errors = fieldErrors.stream().map(x -> new HashMap<>(Map.of(x.getField(), x.getDefaultMessage()))).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ValidationFailureResponse(errors));
    }

    @ExceptionHandler(BindException.class)
    public final ResponseEntity<ValidationFailureResponse> handleBindException(BindException exception) {

        BindingResult result = exception.getBindingResult();

        final List<FieldError> fieldErrors = result.getFieldErrors();

        var errors = fieldErrors.stream().map(x -> new HashMap<>(Map.of(x.getField(), x.getDefaultMessage()))).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ValidationFailureResponse(errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleDefaultException(Exception e) {

        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler(EmployeeDoesNotExistException.class)
    public final ResponseEntity<ApiResponse<?>> handleEmployeeDoesNotExistException(EmployeeDoesNotExistException exception) {

        Set<String> result = new HashSet<>();

        result.add("Not Found");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.of(result));
    }

    @ExceptionHandler(EmployeeAddressDoesNotExistException.class)
    public final ResponseEntity<ApiResponse<?>> handleEmployeeAddressDoesNotExistException(EmployeeAddressDoesNotExistException exception) {

        Set<String> result = new HashSet<>();

        result.add("Not Found");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.of(result));
    }

    @ExceptionHandler(SkillDoesNotExistException.class)
    public final ResponseEntity<ApiResponse<?>> handleSkillDoesNotExistException(SkillDoesNotExistException exception) {

        Set<String> result = new HashSet<>();

        result.add("Not Found");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.of(result));
    }
}
