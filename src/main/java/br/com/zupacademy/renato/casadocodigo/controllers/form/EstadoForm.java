package br.com.zupacademy.renato.casadocodigo.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.model.Pais;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

public class EstadoForm {

	@NotBlank 
	String nome;
	@NotNull
	Long idPais;

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(this.idPais);
		System.out.println(this.idPais);
		Estado estado = new Estado(this.nome, pais.get());
		return estado;
	}
}
