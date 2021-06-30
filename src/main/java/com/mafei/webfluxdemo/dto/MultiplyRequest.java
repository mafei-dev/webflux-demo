package com.mafei.webfluxdemo.dto;

import lombok.Data;
import lombok.ToString;

/*
  @Author mafei
  @Created 6/30/2021 6:29 PM  
*/
@Data
@ToString
public class MultiplyRequest {
    private int first;
    private int second;
}
