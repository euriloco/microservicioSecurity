package com.frc.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(basePackages = "com.frc.model")
@EnableJpaRepositories(basePackages = "com.frc.dao")
@SpringBootApplication(scanBasePackages = {"com.frc.controller","com.frc.service", "com.frc.inicio"})
public class AcademiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaApplication.class, args);
	}

}
