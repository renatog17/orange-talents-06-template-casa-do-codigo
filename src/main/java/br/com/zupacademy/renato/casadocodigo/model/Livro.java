package br.com.zupacademy.renato.casadocodigo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Column(unique = true)
	private String titulo;
	@NotBlank @Column(columnDefinition = "VARCHAR(500)")
	private String resumo;
	private String sumario;
	@DecimalMin("20.00")
	private Double preco;
	@Min(100)
	private Integer qtdPaginas;
	@NotBlank @Column(unique = true)
	private String isbn;
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {
		
	}
	
	public Livro(String titulo, String resumo, String sumario, Double preco, Integer qtdPaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.qtdPaginas = qtdPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
	
	
}
