package com.joey.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(){
		return "hello,world";
	}

}
