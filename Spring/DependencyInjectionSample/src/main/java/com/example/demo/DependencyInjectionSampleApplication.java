package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.chapter03.used.Greet;

@SpringBootApplication
public class DependencyInjectionSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionSampleApplication.class, args)
		.getBean(DependencyInjectionSampleApplication.class).execute();
	}
	
	@Autowired
	Greet greet;
	
	private void execute() {
		greet.greeting();
	}

}
