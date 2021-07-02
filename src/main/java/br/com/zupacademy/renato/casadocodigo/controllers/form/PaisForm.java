package br.com.zupacademy.renato.casadocodigo.controllers.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.renato.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.renato.casadocodigo.model.Pais;

public class PaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	String nome;

	public String getNome() {
		return nome;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}
}
