package com.joey.segmentment.lessson20starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.joey.segmentment.lessson20starter.servlet")
public class Lessson20StarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lessson20StarterApplication.class, args);
	}
}
