package com.dotin.interview.transaction.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.dotin.interview.transaction.processing")
public class TransactionProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionProcessingApplication.class, args);
	}
	
	
}

