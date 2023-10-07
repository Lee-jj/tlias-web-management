package com.leechee.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class helloController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello() {
        System.out.println("hello SpringBoot.");
        return "hello world.";
    }
    
}