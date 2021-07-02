package br.com.zupacademy.renato.casadocodigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.model.Pais;

public interface EstadoRepository extends CrudRepository<Estado, Long>{
	Optional<Estado> findByNomeAndPais(String nome, Pais pais);
	List<Estado> findAllByPais(Pais pais);
	boolean existsByPais(Pais pais);
}
