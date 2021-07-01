package br.com.zupacademy.renato.casadocodigo.controllers.dto;

import br.com.zupacademy.renato.casadocodigo.model.Livro;

public class LivroDetalheDto {

	String titulo;
	String resumo;
	String sumario;
	Double preco;
	Integer qtdPaginas;
	String isbn;
	String nomeAutor;
	String descricaoAutor;

	public LivroDetalheDto(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.qtdPaginas = livro.getQtdPaginas();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}
}
