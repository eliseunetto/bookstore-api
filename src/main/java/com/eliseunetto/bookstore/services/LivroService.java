package com.eliseunetto.bookstore.services;

import java.util.List;
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
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ". Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repo.findAllByCategoria(id_cat);
	}
}
