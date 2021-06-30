package com.mafei.webfluxdemo.dto.exception;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/*
  @Author mafei
  @Created 6/30/2021 6:59 PM  
*/
@Data
@ToString
@Builder
public class InputValidationResponse {
    private int code;
    private int input;
    private String msg;

}
