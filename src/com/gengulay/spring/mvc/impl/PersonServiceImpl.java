package com.gengulay.spring.mvc.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gengulay.spring.mvc.model.Person;
import com.gengulay.spring.mvc.model.Todo;
import com.gengulay.spring.mvc.service.PersonService;

@Repository
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Person> getAllPersons() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select p.name from Person p");
		List<Person> personList = query.list();
		session.flush();
		return personList;
	}

	@Override
	public Person getPersonByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select p from Person p where p.name = " + "'" + username + "'");
		Person p = (Person) query.uniqueResult();
		session.flush();
		return p;
	}

	@Override
	public Person getPersonById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
