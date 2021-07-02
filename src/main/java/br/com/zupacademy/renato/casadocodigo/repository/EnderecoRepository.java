package br.com.zupacademy.renato.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
