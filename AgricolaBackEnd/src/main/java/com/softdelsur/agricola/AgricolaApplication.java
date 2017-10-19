package com.softdelsur.agricola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AgricolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgricolaApplication.class, args);
	}
}
