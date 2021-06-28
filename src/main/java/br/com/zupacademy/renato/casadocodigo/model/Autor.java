package br.com.zupacademy.renato.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	@Column(columnDefinition = "VARCHAR(400)")
	private String descricao;
	private LocalDateTime instanteRegistro = LocalDateTime.now();

	public Autor(String nome, String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstanteRegistro() {
		return instanteRegistro;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteRegistro=" + instanteRegistro + "]";
	}
	
	
}
