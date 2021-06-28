package br.com.zupacademy.renato.casadocodigo.controllers.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.renato.casadocodigo.model.Autor;

public class AutorForm {

	@NotNull
	@NotEmpty
	String nome;
	@NotNull
	@Email
	@NotEmpty
	String email;
	@NotNull
	@NotEmpty
	@Length(max = 400)
	String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converterFormParaModel() {
		Autor autor = new Autor(this.nome, this.email, this.descricao);
		return autor;
	}
}
