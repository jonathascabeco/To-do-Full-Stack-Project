package com.jonathascabeco.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.todo.domain.Todo;
import com.jonathascabeco.todo.repositories.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository repo;
	
	public Todo findById(Integer id) {
		Optional<Todo> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repo.findAllOpen();
		return list;
	}
	
	public List<Todo> findAllClosed() {
		List<Todo> list = repo.findAllClosed();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repo.findAll();
		return list;
	}
}
