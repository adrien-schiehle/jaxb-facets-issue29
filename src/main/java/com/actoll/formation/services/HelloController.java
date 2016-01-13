package com.actoll.formation.services;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(@RequestParam( value = "name", required = true ) String name) {
        String msg = "Greetings from Spring Boot! My name is : " + name;
        return msg;
    }
}