package br.com.zupacademy.renato.casadocodigo.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renato.casadocodigo.model.Categoria;

public class CategoriaForm {

	@NotNull
	@NotEmpty
	String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		Categoria categoria = new Categoria(nome);
		return categoria;
	}
}
