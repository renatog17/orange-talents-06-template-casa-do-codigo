package br.com.zupacademy.renato.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	
}
