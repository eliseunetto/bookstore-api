package com.eliseunetto.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eliseunetto.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		if(strategy.equals("create")) {
			System.out.println("Entrei no metodo instancia dados");
			dbService.instanciaBaseDeDados();
			System.out.println("Instanciei os dados");
			return true;
		}
		System.out.println("Retornei false");
		return false;
	}
}

