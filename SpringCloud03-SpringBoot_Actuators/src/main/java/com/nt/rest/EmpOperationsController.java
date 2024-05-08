package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class EmpOperationsController {

	@GetMapping("/get")
	public ResponseEntity<String> getEmpDetails() {
		return new ResponseEntity<String>("Student Name : Syed Nazeer", HttpStatus.OK);
	}
}
