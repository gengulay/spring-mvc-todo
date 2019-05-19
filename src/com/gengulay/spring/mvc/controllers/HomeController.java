package com.gengulay.spring.mvc.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gengulay.spring.mvc.model.Person;
import com.gengulay.spring.mvc.model.Todo;
import com.gengulay.spring.mvc.service.PersonService;
import com.gengulay.spring.mvc.service.TodoService;

@Controller
public class HomeController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private PersonService personService;

	@RequestMapping("/todoList")
	public String getTodos(Model model) {
		List<Todo> todoList = todoService.getAllTodos();
		model.addAttribute("todoList", todoList);

		return "todoList";
	}

	@RequestMapping("/personList")
	public String getAllPersons(Model model) {
		List<Person> personList = personService.getAllPersons();
		model.addAttribute("personList", personList);
		return "personList";

	}

	@RequestMapping("/personList/person/{name}")
	public String getTodosByUsername(Model model, @PathVariable String name) {
		Person person = personService.getPersonByUsername(name);
		List<Todo> todoList = todoService.getTodoByUsername(name);
		model.addAttribute("todoList", todoList);
		model.addAttribute("person", person);
		System.out.println(todoList + "debug");
		return "viewPerson";

	}

	@RequestMapping("/addTodo")
	public String addTodoGet(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		DateFormat dateFormat = new SimpleDateFormat("mm/MM/yyy HH:mm:ss");
		Date date = new Date();
		todo.setEndDate(new Date());

		List<Person> personList = personService.getAllPersons();
		model.addAttribute("personList", personList);
		return "addTodo";
	}

	@RequestMapping(value = "/addTodo", method = RequestMethod.POST)
	public String addTodoPost(@ModelAttribute("todo") Todo todo) {
		todoService.addTodo(todo);
		return "redirect:/personList/person/" + todo.getPersonName();
	}

	@RequestMapping("/")
	public String showHome() {

		return "home";
	}
}
