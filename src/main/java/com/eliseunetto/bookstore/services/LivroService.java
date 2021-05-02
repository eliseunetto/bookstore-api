package com.eliseunetto.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseunetto.bookstore.domain.Categoria;
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
	
	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		if(obj.getTitulo() != null) {
			newObj.setTitulo(obj.getTitulo());
		}
		if(obj.getAutor() != null) {
			newObj.setAutor(obj.getAutor());
		}
		if(obj.getTexto() != null) {
			newObj.setTexto(obj.getTexto());
		}
	}
	
	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repo.save(obj);
	}
}
