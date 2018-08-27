package com.joey.springboot.segment.springbootjoeylesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringBootJoeyLesson1Application extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootJoeyLesson1Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJoeyLesson1Application.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "hello world";
	}

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
