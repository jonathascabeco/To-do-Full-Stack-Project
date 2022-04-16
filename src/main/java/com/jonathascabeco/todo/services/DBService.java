package com.jonathascabeco.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathascabeco.todo.domain.Todo;
import com.jonathascabeco.todo.repositories.ToDoRepository;

@Service
public class DBService {

	@Autowired
	private ToDoRepository todoRepo;

	public void instanceDataBase() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo t1 = new Todo(null, "Study", "Study Spring Boot and Angular",
				LocalDateTime.parse("02/04/2022 11:30", formatter), false);

		todoRepo.saveAll(Arrays.asList(t1));
	}
}
