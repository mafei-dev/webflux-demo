package com.mafei.webfluxdemo.service;

import com.mafei.webfluxdemo.dto.Response;
import com.mafei.webfluxdemo.utils.SleepUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
  @Author mafei
  @Created 6/30/2021 5:09 PM  
*/
@Service
@Log4j2
public class MathService {
    public Response findSquare(int input) {
        return new Response(input * input);
    }

    public List<Response> multiplicationList(int input) {
        List<Response> list = IntStream.rangeClosed(1, 10)
                .peek(
                        value -> {
                            SleepUtil.sleepSeconds(1);
                        }
                )
                .peek(
                        value -> {
                            log.debug("processing : {}", value);
                        }
                )
                .mapToObj(
                        value -> {
                            return new Response(value * input);
                        }
                )
                .collect(Collectors.toList());
        return list;
    }
}
