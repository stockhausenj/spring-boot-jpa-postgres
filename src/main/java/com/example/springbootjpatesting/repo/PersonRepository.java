package com.example.springbootjpatesting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjpatesting.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findById(long id);

  List<Person> findByLastName(String lastName);
}
