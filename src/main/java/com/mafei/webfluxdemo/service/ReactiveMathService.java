package com.mafei.webfluxdemo.service;

import com.mafei.webfluxdemo.dto.Response;
import com.mafei.webfluxdemo.utils.SleepUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
  @Author mafei
  @Created 6/30/2021 5:09 PM  
*/
@Service
@Log4j2
public class ReactiveMathService {

    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> {
            return input * input;
        }).map(Response::new);
    }

    public Flux<Response> multiplicationList(int input) {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                /*              .doOnNext(
                                      i -> {
                                          SleepUtil.sleepSeconds(1);
                                      }
                              )*/
                .doOnNext(
                        i -> {
                            log.debug("processing : {}", i);
                        }
                ).map(
                        i -> {
                            return new Response(i * input);
                        }
                );
    }
}
