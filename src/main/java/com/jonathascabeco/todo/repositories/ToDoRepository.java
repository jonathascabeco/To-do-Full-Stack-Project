package com.jonathascabeco.todo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jonathascabeco.todo.domain.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Integer> {	
	
	@Query("SELECT obj FROM Todo obj WHERE obj.finished = false ORDER BY obj.dateFinal ASC")
	//selecionando obj do Todo onde o status nao seja finalizado e ordena ele por data;
	// estava com dois pontos no false e deu erro; os dois pontos é utilizado como parametro um valor
	// nesse caso, está apenas sendo validade se ele é verdadeiro ou falso, ou seja, nao há necessidade;
	List<Todo> findAllOpen();
	
	@Query("SELECT obj FROM Todo obj WHERE obj.finished = true ORDER BY dateFinal ASC")
	List<Todo> findAllClosed();
}
