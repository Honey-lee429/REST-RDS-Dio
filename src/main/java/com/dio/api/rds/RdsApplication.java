package com.dio.api.rds;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dio.api.rds.model.Person;
import com.dio.api.rds.repository.PersonRepository;

@SpringBootApplication
public class RdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository repository) {
		return resp -> {
			repository.save(new Person("João","Da Silva"));
			repository.save(new Person("Mari", "Menezes"));
		};
	};
}
