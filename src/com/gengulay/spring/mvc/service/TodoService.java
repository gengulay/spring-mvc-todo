package com.gengulay.spring.mvc.service;

import java.util.List;

import com.gengulay.spring.mvc.model.Todo;

public interface TodoService {

	List<Todo> getAllTodos();

	List<Todo> getTodoByUsername(String username);

	Todo getTodoById(int id);

	Todo getTodoByUserId(int id);

	void addTodo(Todo todo);

}
