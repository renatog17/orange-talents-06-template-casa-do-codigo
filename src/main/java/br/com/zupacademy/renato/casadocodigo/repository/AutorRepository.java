package br.com.zupacademy.renato.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);
	
}
