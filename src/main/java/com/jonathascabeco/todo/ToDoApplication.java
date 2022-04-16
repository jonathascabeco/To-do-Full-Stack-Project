package com.jonathascabeco.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonathascabeco.todo.domain.Todo;
import com.jonathascabeco.todo.repositories.ToDoRepository;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner{

	@Autowired
	private ToDoRepository todoRepo;	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
		//anotação para identificar a subida para o TOmCat
	}
	
	//roda a aplicação em tempo de salvamento;
	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");		
		Todo t1 =  new Todo(null, "Study", "Study Spring Boot and Angular", LocalDateTime.parse("02/04/2022 11:30", formatter), false);
		
		todoRepo.saveAll(Arrays.asList(t1));
	}

}
