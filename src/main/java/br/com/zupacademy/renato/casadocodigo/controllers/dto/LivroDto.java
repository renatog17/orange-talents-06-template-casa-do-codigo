package br.com.zupacademy.renato.casadocodigo.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.zupacademy.renato.casadocodigo.model.Livro;

public class LivroDto {

	Long id;
	String titulo;
	
	public LivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static Page<LivroDto> converter(Page<Livro> livros) {
		
		return livros.map(LivroDto::new);
	}

}
