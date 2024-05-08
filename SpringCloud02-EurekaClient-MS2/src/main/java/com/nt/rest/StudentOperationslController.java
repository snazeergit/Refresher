package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOperationslController {

	@Value("${dbUser}")
	private String usr;

	@Value("${dbPassword}")
	private String pwd;

	@GetMapping("/get")
	public ResponseEntity<String> getDBDetailsFromConfigServer() {
		return new ResponseEntity<String>("DB USER: " + usr + " DB PASSWORD: " + pwd, HttpStatus.OK);
	}
}
