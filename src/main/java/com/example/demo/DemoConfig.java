package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class DemoConfig {

    @Bean
    public ExecutorService timeoutExecutors() {
        return Executors.newSingleThreadExecutor();
    }
}
