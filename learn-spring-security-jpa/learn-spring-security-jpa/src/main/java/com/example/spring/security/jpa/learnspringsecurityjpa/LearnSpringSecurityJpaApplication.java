package com.example.spring.security.jpa.learnspringsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
public class LearnSpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityJpaApplication.class, args);
	}

}
