package com.postgres.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RegistrationPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationPostgresApplication.class, args);
	}

}
