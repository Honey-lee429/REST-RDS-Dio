package com.dio.api.rds.controller;

import java.util.List;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.api.rds.model.Person;
import com.dio.api.rds.repository.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class PersonController {

	private PersonRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Person>> getAll(){
		List<Person> person =  repository.findAll();
		if (person.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getId(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		}
	
	
	
}
