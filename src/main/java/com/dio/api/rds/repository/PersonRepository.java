package com.dio.api.rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.api.rds.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
