package com.upgrad.IdeasProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class IdeasProjectApplication {

	public static void main(String[] args) {


		SpringApplication.run(IdeasProjectApplication.class, args);

		System.out.println("Hello World");
	}

}
