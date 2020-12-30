package com.happy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HappyfamilyApplication {
	public static void main(String[] args) {
		SpringApplication.run(HappyfamilyApplication.class, args);
	}
}
