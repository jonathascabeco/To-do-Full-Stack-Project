package com.jonathascabeco.todo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String description;
	private LocalDateTime dateFinal; // data local;
	private Boolean finished = false;
	// indica se o to-do está ou não finalizado, começa como falsa por motivo lógico;
	
	public Todo() {
		super();
	}

	public Todo(Integer id, String title, String description, LocalDateTime dateFinal, Boolean finished) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateFinal = dateFinal;
		this.finished = finished;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(LocalDateTime dateFinal) {
		this.dateFinal = dateFinal;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(id, other.id);
	}	
}
