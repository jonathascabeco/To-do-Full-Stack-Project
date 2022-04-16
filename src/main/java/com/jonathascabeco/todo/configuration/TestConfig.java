package com.jonathascabeco.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jonathascabeco.todo.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	//iniciara sempre que uma nova instancia do testconfig for iniciado;
	//sempre que o perfil ativo for o de teste ele vai instanciar esse serviço do bd;
	//isso porque pode-se ter vários perfis: desenvolvimento, produção, homologação;
	public boolean instance() {
		this.dbService.instanceDataBase();
		return true;
	}
}
