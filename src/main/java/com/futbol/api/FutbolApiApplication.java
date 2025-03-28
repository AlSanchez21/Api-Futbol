package com.futbol.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.futbol.api.repositories")
public class FutbolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbolApiApplication.class, args);
	}

}
