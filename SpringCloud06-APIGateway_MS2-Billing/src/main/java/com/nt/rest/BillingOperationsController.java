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
@RequestMapping("/billing/api")
public class BillingOperationsController {

	@Autowired
	private RestTemplate template;
	Logger logger = LoggerFactory.getLogger(BillingOperationsController.class);

	@GetMapping("/bill")
	public ResponseEntity<String> doBilling() {
		logger.info("Welcome to Billing module");
		//Communication with Payment Service
		ResponseEntity<String> res = template.exchange("http://localhost:9093/payment/api/pay", HttpMethod.GET, null,
				String.class);
		String body = res.getBody();
		logger.info("Back to Billing module " + body);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}