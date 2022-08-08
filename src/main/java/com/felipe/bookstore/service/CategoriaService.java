package com.felipe.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.bookstore.domain.Categoria;
import com.felipe.bookstore.exception.ObjectNotFoundException;
import com.felipe.bookstore.repositories.CategoriaRespository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRespository respository;

	public Categoria findyById(Integer id) {
		Optional<Categoria> obj = respository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll(){
		return respository.findAll();
	}

	public Categoria create(Categoria obj){
		obj.setId(null);
		return respository.save(obj);
	}
}
