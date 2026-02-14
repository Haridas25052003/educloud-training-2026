package com.educloud.enumdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educloud.enumdemo.enums.PaymentStatus;

@RestController
public class PaymentController {

    @GetMapping("/status")
public PaymentStatus getStatus(@RequestParam PaymentStatus paymentStatus) {
    return paymentStatus;
}

    
}
