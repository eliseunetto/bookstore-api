package com.eliseunetto.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseunetto.bookstore.domain.Categoria;
import com.eliseunetto.bookstore.domain.Livro;
import com.eliseunetto.bookstore.repositories.CategoriaRepository;
import com.eliseunetto.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Livro de Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", 
					"What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", 
					"What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
				cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", 
					"What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
				cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", 
					"What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
				cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", 
					"What is Lorem Ipsum?\r\n"
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
				cat2);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
	}
}
