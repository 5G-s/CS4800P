package com.example.demo;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//joda time
import java.time.*;

//Jsoup HTML Parse & Print
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.lang.Math;


@SpringBootApplication
@RestController
public class WebController {

    public static void main(String args[]) {
        SpringApplication.run(WebController.class, args);
    }
    @GetMapping("/beer")
    public static double area(@RequestParam int distance) {
        return distance * Math.pow(3.14, 2);

    }
    public static void parseLink() {
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("https://www.brewtrail.com/california-breweries/").userAgent("Mozilla").get();

            // get page title
            String title = doc.title();
            //System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
                //return link.attr("href");
                //return link.text();

            }
           // return title;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return  phoneRegion(name);
    }

    @GetMapping("/date")
    public String date() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    private static String phoneRegion(String user) {
        Phonenumber.PhoneNumber number = null;
        boolean real;

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        try {
            number = phoneUtil.parse(user, "US");
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        real = phoneUtil.isValidNumber(number);
        if(!real){
            return "Not a local number";
        }
        return "Number is Local";
    }

}
