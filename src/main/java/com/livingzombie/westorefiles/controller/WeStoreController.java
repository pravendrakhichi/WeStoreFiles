package com.livingzombie.westorefiles.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;

@Controller
public class WeStoreController {

    @RequestMapping("/")
    public ResponseEntity<String> helloWorld(){
        System.out.println("gelo");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
