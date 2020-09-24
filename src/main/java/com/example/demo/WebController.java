package com.example.demo;

import com.github.ankurpathak.username.bean.constraints.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class WebController {


    public static void main(String[] args) {

        SpringApplication.run(WebController.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }



//    StartWithAlphabet to check if username start with alphabet
    private String verifyName() {
        @StartWithAlphabet

        String users = null;
        return users;

    }

}