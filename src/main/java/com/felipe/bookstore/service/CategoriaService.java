package com.felipe.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.bookstore.domain.Categoria;
import com.felipe.bookstore.repositories.CategoriaRespository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRespository respository;
	
	
	public Categoria findyById(Integer id) {
	 	Optional<Categoria> obj = respository.findById(id);
	 	return obj.orElse(null);
	}

}
