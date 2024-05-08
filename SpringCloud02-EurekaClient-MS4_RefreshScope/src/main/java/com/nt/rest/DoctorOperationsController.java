package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc/api")
@RefreshScope
public class DoctorOperationsController {

	@Value("${dbUser}")
	private String user;
	@Value("${dbPassword}")
	private String password;

	@GetMapping("/op")
	public ResponseEntity<String> getDBDetaisl() {
		return new ResponseEntity<String>(" Username : " + user + "  Password: " + password, HttpStatus.OK);
	}
}
