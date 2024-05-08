package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.Consumer_DiscoveryClient;
import com.nt.client.Consumer_LoadBalancerClient;
import com.nt.client.IConsumer_FeignClient;

@RestController
@RequestMapping("/consumer/api")
public class ConsumerRestController {

	@Autowired
	private IConsumer_FeignClient client;

	@GetMapping("/info")
	public ResponseEntity<String> getConsumerMessage() {
		ResponseEntity<String> response = client.getProviderInstance();
		String providerResponseBody = response.getBody();
		return new ResponseEntity<>("<h1>Consumer Service invoked. </h1>" + providerResponseBody, HttpStatus.OK);
	}
}