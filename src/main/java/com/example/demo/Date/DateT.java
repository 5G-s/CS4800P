package com.example.demo.Date;

import java.time.LocalDate;

import org.joda.time.DateTime;

public class DateT {

	public String string() {
        return LocalDate.now().toString();
	}
	
	public int getYear() {
		DateTime dt = new DateTime();
		return dt.getYear();
	}
	public int getMonth() {
		DateTime dt = new DateTime();
		return dt.getMonthOfYear();
	}
}
