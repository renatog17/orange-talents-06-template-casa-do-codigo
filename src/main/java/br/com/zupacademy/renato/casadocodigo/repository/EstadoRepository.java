package br.com.zupacademy.renato.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.model.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	Optional<Estado> findByNomeAndPais(String nome, Pais pais);
}
