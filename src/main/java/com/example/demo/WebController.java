package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//joda time
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;


//@SpringBootApplication
//@RestController
public class WebController {
	
	public static void main(String args[]) {
		LocalDate date = LocalDate.now();
		System.out.println(date); 
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}

   @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
