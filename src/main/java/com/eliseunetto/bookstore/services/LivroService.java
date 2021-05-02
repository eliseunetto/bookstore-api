package com.eliseunetto.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseunetto.bookstore.domain.Livro;
import com.eliseunetto.bookstore.repositories.LivroRepository;
import com.eliseunetto.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ". Tipo: " + Livro.class.getName()));
	}
}
