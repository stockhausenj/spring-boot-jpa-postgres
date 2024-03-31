package com.example.springbootjpapostgres.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjpapostgres.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findById(long id);

  List<Person> findByLastName(String lastName);
}
