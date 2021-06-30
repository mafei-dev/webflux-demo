package com.mafei.webfluxdemo.controller;

import com.mafei.webfluxdemo.dto.Response;
import com.mafei.webfluxdemo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
  @Author mafei
  @Created 6/30/2021 5:18 PM  
*/
@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;


    @GetMapping("/square/{input}")
    public ResponseEntity<Response> findSquare(@PathVariable("input") int input) {
        return ResponseEntity.ok().body(this.mathService.findSquare(input));
    }

    @GetMapping("/table/{input}")
    public ResponseEntity<List<Response>> multiplicationTable(@PathVariable("input") int input) {
        return ResponseEntity.ok().body(this.mathService.multiplicationList(input));
    }
}
