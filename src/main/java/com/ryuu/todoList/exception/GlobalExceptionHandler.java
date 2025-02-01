package com.ryuu.todoList.exception;

import com.ryuu.todoList.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponse> taskNotFoundExceptionHandler(TaskNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }
}
