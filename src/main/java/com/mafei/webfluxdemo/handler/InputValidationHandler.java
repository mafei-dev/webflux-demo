package com.mafei.webfluxdemo.handler;

import com.mafei.webfluxdemo.dto.exception.InputValidationResponse;
import com.mafei.webfluxdemo.exception.InputValidationException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
  @Author mafei
  @Created 6/30/2021 7:08 PM  
*/
@ControllerAdvice
public class InputValidationHandler {
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputValidationResponse> handleInputValidationException(InputValidationException e) {
        InputValidationResponse response = InputValidationResponse
                .builder()
                .code(InputValidationException.ERROR_CODE)
                .msg(e.getMessage())
                .input(e.getInput())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
