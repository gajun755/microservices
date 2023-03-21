package com.isomorphs.sso;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringSsoOktaApplication {

	@GetMapping("/")
	public String welcome2User(Principal principal){
		
		return "Hi "+principal.getName()+	" Welcome to isomorphs";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSsoOktaApplication.class, args);
	}

}
