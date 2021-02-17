package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class DemoService {

    private final Logger LOG = LoggerFactory.getLogger(DemoService.class);

    private final ExecutorService executor;

    public DemoService(ExecutorService executor) {
        this.executor = executor;
    }

    public DemoResponse findById(int id) {
        LOG.info("Default service method");
        return new DemoResponse(id, "sample");
    }

    public Future<DemoResponse> findByIdAsync(int id) {
        LOG.info("Async service method");
        return executor.submit(() -> {
            double randomSleep = Math.random() * 1000L * id;
            LOG.info("Sleep {} milliseconds.", randomSleep);
            Thread.sleep((long) randomSleep);
            return new DemoResponse(id, "asyncSample");
        });
    }
}
