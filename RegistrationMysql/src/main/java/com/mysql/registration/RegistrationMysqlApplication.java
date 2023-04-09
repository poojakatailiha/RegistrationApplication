package com.mysql.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RegistrationMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationMysqlApplication.class, args);
	}

}
