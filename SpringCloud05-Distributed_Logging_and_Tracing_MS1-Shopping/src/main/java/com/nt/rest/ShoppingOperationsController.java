package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingOperationsController {

	@Autowired
	private RestTemplate template;
	Logger logger = LoggerFactory.getLogger(ShoppingOperationsController.class);

	@GetMapping("/shop")
	public ResponseEntity<String> doShopping() {
		logger.info("Welcome to shopping module");
		//Communication with Billing Service
		ResponseEntity<String> res = template.exchange("http://localhost:9092/billing/api/bill", HttpMethod.GET, null,
				String.class);
		String body = res.getBody();
		logger.info("Back to Shopping module " + body);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}