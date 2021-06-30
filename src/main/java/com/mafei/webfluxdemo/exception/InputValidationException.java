package com.mafei.webfluxdemo.exception;

import lombok.Builder;
import lombok.Getter;

/*
  @Author mafei
  @Created 6/30/2021 7:01 PM  
*/
@Getter
public class InputValidationException extends RuntimeException {
    public static final String MSG_ERROR = "Range must be less than 10";
    public static final int ERROR_CODE = 99;
    private final int input;

    public InputValidationException(int input) {
        super(MSG_ERROR);
        this.input = input;
    }
}
