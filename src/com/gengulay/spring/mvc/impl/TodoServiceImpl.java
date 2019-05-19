package com.gengulay.spring.mvc.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gengulay.spring.mvc.model.Todo;
import com.gengulay.spring.mvc.service.TodoService;

@Repository
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Todo> getAllTodos() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Todo");
		List<Todo> todoList = query.list();
		session.flush();
		return todoList;
	}

	@Override
	public List<Todo> getTodoByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select t from Todo t where t.personName = " + "'" + username + "'");
		List<Todo> todoList = query.list();
		session.flush();
		return todoList;
	}

	@Override
	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo getTodoByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(todo);
		session.flush();

	}

}
