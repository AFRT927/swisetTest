package com.example.tradingaccountmanagementApplication.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class hello {

    @RequestMapping("/hello")
    public String sayHi() {
        System.out.println("hi executed");
        return "hi";
    }
}