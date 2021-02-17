package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class DemoControllerAdvice {

    private final Logger LOG = LoggerFactory.getLogger(DemoControllerAdvice.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(TimeoutException.class)
    public DemoResponse handleTimeout(TimeoutException e) {
        LOG.error(e.getMessage());
        return new DemoResponse(0, "timeout");
    }
}
