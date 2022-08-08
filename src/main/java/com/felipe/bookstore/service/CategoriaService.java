package com.felipe.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.felipe.bookstore.dtos.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findyById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return respository.save(obj);
	}

	public void delete(Integer id) {
		findyById(id);
		try {
			respository.deleteById(id);
		}catch (DataIntegrityViolationException e){
             throw new com.felipe.bookstore.exception.DataIntegrityViolationException("Categoria não pode ser deletada!Possui livros associados.");
		}
	}
}
