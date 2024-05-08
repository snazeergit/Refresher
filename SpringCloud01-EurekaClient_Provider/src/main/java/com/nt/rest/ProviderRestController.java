package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider/api")
public class ProviderRestController {

	@GetMapping("/info")
	public ResponseEntity<String> getProviderMessage() {
		return new ResponseEntity<String>("<h1>Provider service invoked. </h1>", HttpStatus.OK);
	}
}
