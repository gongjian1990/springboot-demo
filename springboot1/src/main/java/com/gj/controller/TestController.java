package com.gj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/testException1")
    public String testException1() throws Exception {
        
        throw new Exception();
        
    }

    @RequestMapping("/testException2")
    public String testException2()  {

        int i = 1 / 0;
        return "";

    }
}
