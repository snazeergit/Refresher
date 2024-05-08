package com.nt.rest;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket/api")
public class TicketBookingRestController {
	int i = 1;

	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyBookTicket", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true") })
	public String bookTickets() {
		System.out.print(LocalDateTime.now() + " bookTickets() ");

		if (new Random().nextInt(10) < 2) {
			System.out.println();
			throw new RuntimeException("Server encounted an unrecoverable problem");
		}
		i = 1;
		return "Ticket booking successful";
	}

	public String dummyBookTicket() {
		System.err.println(LocalDateTime.now() + " dummyBookTicket() " + i);
		i++;
		return "Server is under maintenance, please try again after some time";
	}
}