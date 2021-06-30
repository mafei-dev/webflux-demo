package com.mafei.webfluxdemo.controller;

import com.mafei.webfluxdemo.dto.MultiplyRequest;
import com.mafei.webfluxdemo.dto.Response;
import com.mafei.webfluxdemo.exception.InputValidationException;
import com.mafei.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
  @Author mafei
  @Created 6/30/2021 5:18 PM  
*/
@RestController
@RequestMapping("/reactive/math/validation")
public class ReactiveMathValidationController {

    @Autowired
    private ReactiveMathService reactiveMathService;


    @GetMapping("/square/{input}")
    public Mono<Response> findSquare(@PathVariable("input") int input) {
        if (input > 10) {
            throw new InputValidationException(input);
        }
        return this.reactiveMathService.findSquare(input);
    }


    @GetMapping("/square/{input}/mono")
    public Mono<Response> findSquareMonoEx(@PathVariable("input") int input) {
        return Mono.just(input).handle((_input, synchronousSink) -> {
            if (_input > 10) {
                synchronousSink.error(new InputValidationException(_input));
            } else {
                synchronousSink.next(_input);
            }
        }).cast(Integer.class).flatMap(_input -> this.reactiveMathService.findSquare(_input));
    }


}
