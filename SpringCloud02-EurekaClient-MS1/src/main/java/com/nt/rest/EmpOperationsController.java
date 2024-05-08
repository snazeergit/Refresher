package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class EmpOperationsController {

	@Value("${dbUser}")
	private String dbusr;

	@Value("${dbPassword}")
	private String dbpwd;

	@GetMapping("/fetch")
	public ResponseEntity<String> fetchDbDetailsFromConfigServer() {
		return new ResponseEntity<String>("DB username: " + dbusr + " DB password: " + dbpwd, HttpStatus.OK);
	}
}
