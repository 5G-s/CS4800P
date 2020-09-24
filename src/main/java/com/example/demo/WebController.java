package com.example.demo;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

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
    public String sayHello(@RequestParam(value = "myName") String name) {
        return  phoneRegion(name);
    }



//    StartWithAlphabet to check if username start with alphabet
    private String phoneRegion(String user) {
        PhoneNumber swissNumberProto = null;
        boolean real;

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        
        try {
            swissNumberProto = phoneUtil.parse(user, "US");
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        real = phoneUtil.isValidNumber(swissNumberProto);
        if(!real){
            return "Not a local number";
        }
        return "Number is Local";
    }


}