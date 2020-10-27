package com.example.demo;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;


//joda time
import java.time.*;

//Jsoup HTML Parse & Print


@SpringBootApplication
@RestController
public class WebApplication extends HttpServlet {

    public static void main(String args[]) {
        SpringApplication.run(WebApplication.class, args);

    }

    @GetMapping("/date")
    public String date() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }


}
