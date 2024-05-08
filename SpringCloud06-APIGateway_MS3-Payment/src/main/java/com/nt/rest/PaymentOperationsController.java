package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/api")
public class PaymentOperationsController {

	Logger logger = LoggerFactory.getLogger(PaymentOperationsController.class);

	@GetMapping("/pay")
	public ResponseEntity<String> doPayment() {
		logger.info("Welcome to Payment module");
		return new ResponseEntity<String>("Payment is successful...! Visit Again.", HttpStatus.OK);
	}
}