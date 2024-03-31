package com.example.springbootjpapostgres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springbootjpapostgres.model.Person;
import com.example.springbootjpapostgres.repo.PersonRepository;


@SpringBootApplication
public class SpringBootJpaPostgresApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaPostgresApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaPostgresApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(PersonRepository repository) {
      return (args) -> {
        // save a few customers
        repository.save(new Person("Jack", "Bauer"));
        repository.save(new Person("Chloe", "O'Brian"));
        repository.save(new Person("Kim", "Bauer"));
  
        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        repository.findAll().forEach(user -> {
          log.info(user.toString());
        });
        log.info("");
  
        // fetch an individual customer by ID
        Person user = repository.findById(1L);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(user.toString());
        log.info("");
  
        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
          log.info(bauer.toString());
        });
        log.info("");
      };
    }
}