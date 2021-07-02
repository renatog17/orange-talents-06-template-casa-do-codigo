package br.com.zupacademy.renato.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String rua;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	@ManyToOne
	private Estado estado;
	@NotNull
	@ManyToOne
	private Pais pais;
	public Endereco(@NotBlank String rua, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String cep,
		 Estado estado, Pais pais) {
		super();
		this.rua = rua;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
	}
	
	
	
}
