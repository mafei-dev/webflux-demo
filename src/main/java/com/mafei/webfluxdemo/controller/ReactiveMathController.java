package com.mafei.webfluxdemo.controller;

import com.mafei.webfluxdemo.dto.Response;
import com.mafei.webfluxdemo.service.MathService;
import com.mafei.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/*
  @Author mafei
  @Created 6/30/2021 5:18 PM  
*/
@RestController
@RequestMapping("/reactive/math")
public class ReactiveMathController {

    @Autowired
    private ReactiveMathService reactiveMathService;


    @GetMapping("/square/{input}")
    public Mono<Response> findSquare(@PathVariable("input") int input) {
        return this.reactiveMathService.findSquare(input);
    }

    @GetMapping("/table/{input}")
    public Flux<Response> multiplicationTable(@PathVariable("input") int input) {
        return this.reactiveMathService.multiplicationList(input);
    }


    @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTableStream(@PathVariable("input") int input) {
        return this.reactiveMathService.multiplicationList(input);
    }


}
