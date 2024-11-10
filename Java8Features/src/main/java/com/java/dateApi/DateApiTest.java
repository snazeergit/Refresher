package com.java.dateApi;

import java.time.LocalDate;
import java.time.Period;

public class DateApiTest {

	public static void main(String[] args) {

		LocalDate birthday = LocalDate.of(1995, 04, 29);
		LocalDate now = LocalDate.now();
		Period period = Period.between(birthday, now);
		System.out.printf("You age is "+period.getYears()+" years "+period.getMonths()+ " months "+period.getDays()+ " days old.");
	}

}
