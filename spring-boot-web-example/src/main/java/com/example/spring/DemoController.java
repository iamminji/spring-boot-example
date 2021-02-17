package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

@RestController
public class DemoController {

    private final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/sample/timeout/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public DemoResponse getWhenTimeout(@PathVariable("id") int id) throws ExecutionException, InterruptedException {
        Future<DemoResponse> future = service.findByIdAsync(id);
        try {
            return future.get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            LOG.error("Fail to get id:{}, Exception:{}", id, e.getMessage());
            future.cancel(true);
            return new DemoResponse(id, "timeout");
        }
    }

    @RequestMapping(value = "/sample/default/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public DemoResponse get(@PathVariable("id") int id) {
        return service.findById(id);
    }

}
