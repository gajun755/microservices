package com.dedication.account;

	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableEurekaClient
public class AccountServiceApplication {

	
	
	
	
	@GetMapping("/")
	public ResponseEntity<String> home(){
		
		return new ResponseEntity<String>("Home",HttpStatus.OK);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}
