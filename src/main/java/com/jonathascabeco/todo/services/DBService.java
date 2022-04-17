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
		Todo t1 = new Todo(null, "Study day 1", "Study Spring Boot and Angular",
				LocalDateTime.parse("02/04/2022 11:30", formatter), false);

		Todo t2 = new Todo(null, "Study day 2", "Study HTML/Css and JavaScript",
				LocalDateTime.parse("03/04/2022 12:30", formatter), true);

		Todo t3 = new Todo(null, "Study day 3", "Study React and Nodejs",
				LocalDateTime.parse("04/04/2022 15:30", formatter), false);
		
		Todo t4 = new Todo(null, "Study study day 4", "Study MySQL and MongoDB",
				LocalDateTime.parse("05/04/2022 17:30", formatter), true);	
		
		todoRepo.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
