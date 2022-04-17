package com.jonathascabeco.todo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathascabeco.todo.domain.Todo;
import com.jonathascabeco.todo.services.ToDoService;

@RestController
@RequestMapping(value = "/todos")
public class ToDoResource {
	
	@Autowired
	private ToDoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id){
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen(){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
		//retornando a lista pro app
	} 
	
	@GetMapping(value = "/closed")
	public ResponseEntity<List<Todo>> listClosed(){
		List<Todo> list = service.findAllClosed();
		return ResponseEntity.ok().body(list);
		//retornando a lista pro app
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> listAll(){
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}	
}
