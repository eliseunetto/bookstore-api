package com.eliseunetto.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseunetto.bookstore.domain.Categoria;
import com.eliseunetto.bookstore.repositories.CategoriaRepository;
import com.eliseunetto.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ". Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
