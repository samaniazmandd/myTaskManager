package com.example.myTaskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
public class MyTaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTaskmanagerApplication.class, args);
	}

}
