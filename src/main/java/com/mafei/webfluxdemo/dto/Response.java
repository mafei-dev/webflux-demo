package com.mafei.webfluxdemo.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/*
  @Author mafei
  @Created 6/30/2021 5:07 PM  
*/
@Data
@ToString
public class Response {
    private Date date=new Date();
    private int output;

    public Response(int output) {
        this.output = output;
    }
}
