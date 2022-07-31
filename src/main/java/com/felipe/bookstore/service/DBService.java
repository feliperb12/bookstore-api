package com.felipe.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.bookstore.domain.Categoria;
import com.felipe.bookstore.domain.Livro;
import com.felipe.bookstore.repositories.CategoriaRespository;
import com.felipe.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRespository categoriaRespository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Geografia", "Livros de mapeamento geográfico");
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro livro2 = new Livro(null, "Primeira Guerra Mundial", "Staffor Creck", "Lorem ipsum", cat2);
		Livro livro3 = new Livro(null, "Python", "Gabaun Traves", "Lorem ipsum", cat1);
		Livro livro4 = new Livro(null, "React", "Gabriela Martin", "Lorem ipsum", cat2);
		Livro livro5 = new Livro(null, "Java", "Pedro Fernando", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(livro1, livro3, livro5));
		cat2.getLivros().addAll(Arrays.asList(livro2, livro4));

		this.categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
	}
}
