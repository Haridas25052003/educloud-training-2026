package com.example.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {

    private static final Logger logger=LogManager.getLogger(TestController.class);

    @GetMapping("/test")
    public String test() {
        logger.info("Test api failed");
        logger.info("debug message");
        logger.error("error example");
        return "check the logs";
    }
    
    
}
