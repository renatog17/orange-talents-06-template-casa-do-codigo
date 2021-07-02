package br.com.zupacademy.renato.casadocodigo.controllers.form;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renato.casadocodigo.config.validacao.UniqueValue;
import br.com.zupacademy.renato.casadocodigo.model.Cliente;
import br.com.zupacademy.renato.casadocodigo.model.Endereco;
import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.model.Pais;
import br.com.zupacademy.renato.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

public class ClienteForm {

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String telefone;

	@NotBlank
	private String rua;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	private Long idEstado;
	@NotNull
	private Long idPais;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getRua() {
		return rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) throws IllegalArgumentException{
		Optional<Pais> pais = paisRepository.findById(this.idPais);
		Estado estado = null;
		if (estadoRepository.existsByPais(pais.get())) {
			System.out.println("ENTROU");
			Optional<Estado> estadoOptional = estadoRepository.findById(this.idEstado);
			System.out.println("ENTROU");
			estado = estadoOptional.get();
		}
		Endereco endereco = new Endereco(this.rua, this.complemento, this.cidade, this.cep, estado, pais.get());
		Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, endereco, this.telefone);
		return cliente;
	}

}
