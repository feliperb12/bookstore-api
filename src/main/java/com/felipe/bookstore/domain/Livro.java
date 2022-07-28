package com.felipe.bookstore.domain;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

	private Integer id;
	private String Titulo;
	private String nome_autor;
	private String texto;

	private Categoria categoria;

	

}
