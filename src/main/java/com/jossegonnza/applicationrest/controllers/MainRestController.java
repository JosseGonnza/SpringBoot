package com.jossegonnza.applicationrest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @RequestMapping("/hello")
    public String getString(){
        return "Hello";
    }

}


