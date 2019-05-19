package com.gengulay.spring.mvc.service;

import java.util.List;

import com.gengulay.spring.mvc.model.Person;

public interface PersonService {

	List<Person> getAllPersons();

	Person getPersonByUsername(String username);

	Person getPersonById(String username);

}
