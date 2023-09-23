package com.petrarca.apicardapio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.petrarca.apicardapio")
public class ApiCardapioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCardapioApplication.class, args);
	}

}
