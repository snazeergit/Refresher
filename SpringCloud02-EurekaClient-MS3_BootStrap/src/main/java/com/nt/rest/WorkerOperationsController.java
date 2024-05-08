package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker/api")
public class WorkerOperationsController {

	@Value("${dbUser}")
	private String usr;

	@Value("${dbPassword}")
	private String pwd;

	@GetMapping("/pull")
	public ResponseEntity<String> pullDBDetails() {
		return new ResponseEntity<String>(" Username : " + usr + " Password : " + pwd, HttpStatus.OK);
	}
}
