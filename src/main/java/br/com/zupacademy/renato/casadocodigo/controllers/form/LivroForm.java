package br.com.zupacademy.renato.casadocodigo.controllers.form;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.renato.casadocodigo.model.Autor;
import br.com.zupacademy.renato.casadocodigo.model.Categoria;
import br.com.zupacademy.renato.casadocodigo.model.Livro;
import br.com.zupacademy.renato.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.renato.casadocodigo.repository.CategoriaRepository;

public class LivroForm {

	@NotBlank
	String titulo;
	@NotBlank
	String resumo;
	String sumario;
	@DecimalMin("20.00")
	@Digits(integer = 6, fraction = 2)
	Double preco;
	@Min(100)
	Integer qtdPaginas;
	@NotBlank
	String isbn;
	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	LocalDate dataPublicacao;
	@NotNull
	Long idCategoria;
	@NotNull
	Long idAutor;
	
	@JsonCreator
	public LivroForm() {
		
	}
	
	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
		Optional<Autor> autor = autorRepository.findById(this.idAutor);
		Livro livro = new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.qtdPaginas, this.isbn,
				this.dataPublicacao, categoria.get(), autor.get());
		return livro;
	}

	@Override
	public String toString() {
		return "LivroForm [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", qtdPaginas=" + qtdPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", idCategoria=" + idCategoria + ", idAutor=" + idAutor + "]";
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

}
