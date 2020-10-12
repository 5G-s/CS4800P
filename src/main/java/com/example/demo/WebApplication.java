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

import java.lang.Math;
@SpringBootApplication
@RestController
public class WebController extends HttpServlet {

    public static void main(String args[]) {
        SpringApplication.run(WebController.class, args);

    }

    @GetMapping("/distance")
    public String area(@RequestParam(value = "myDistance") String distance) {
        double area = Integer.parseInt(distance) * Math.pow(3.14, 2);
        return "Area around you = "+area;
    }

    @GetMapping("/beer")
    public static String parseLink() {
        return "Hyperlink here";
//        Document doc;
//        try {
//
//            // need http protocol
//            doc = Jsoup.connect("https://www.brewtrail.com/california-breweries/").userAgent("Mozilla").get();
//
//            // get page title
//            String title = doc.title();
//            System.out.println("title : " + title);
//
//            // get all links
//            Elements links = doc.select("a[href]");
//            for (Element link : links) {
//
//                // get the value from href attribute
//                return link.attr("href");
//
//            }
//            return title;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @GetMapping("/date")
    public String date() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    //Currently checks if user is local
    @GetMapping("/verify")
    public String phoneVerify(@RequestParam(value = "phoneNumber") String user) {
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
