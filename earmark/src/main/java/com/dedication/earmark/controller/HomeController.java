package com.dedication.earmark.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<String> home(){
		
		RestTemplate rest=new RestTemplate();
		ResponseEntity<String> result=rest.getForEntity("http://localhost:9000/future", String.class);
		System.out.println(result.getBody());
		return new ResponseEntity<>("Home Page",HttpStatus.OK);
	}
	
	@GetMapping("/future")
	public ResponseEntity<String> future(){
		
		return new ResponseEntity<>("Future",HttpStatus.OK);
		
	}
}
