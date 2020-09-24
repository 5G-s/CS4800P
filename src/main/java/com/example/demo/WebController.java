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
		callingTime();
		parseLink();
	}

	public static void callingTime() {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		System.out.println("Today's Date is: " + date);
		System.out.println("Today's Time is: " + time);

	}
	
	public static void parseLink() {
        	Document doc;
        	try {

			// need http protocol
			doc = Jsoup.connect("https://www.brewtrail.com/california-breweries/").userAgent("Mozilla").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {

				// get the value from href attribute
				System.out.println("\nlink : " + link.attr("href"));
				System.out.println("text : " + link.text());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
    	}

   @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
