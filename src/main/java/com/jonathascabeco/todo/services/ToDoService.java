package com.jonathascabeco.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.todo.domain.Todo;
import com.jonathascabeco.todo.repositories.ToDoRepository;
import com.jonathascabeco.todo.services.exceptions.ObjectNotFoundException;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository repo;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Todo.class.getName()));
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

	public Todo created(Todo obj) {
		obj.setId(null);// medida de segurança caso o usuário coloque um id;
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitle(obj.getTitle());
		newObj.setDateFinal(obj.getDateFinal());
		newObj.setDescription(obj.getDescription());
		newObj.setFinished(obj.isFinished());
		return repo.save(newObj);
		 
		
	}
}
