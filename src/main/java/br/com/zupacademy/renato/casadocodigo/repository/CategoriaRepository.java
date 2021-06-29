package br.com.zupacademy.renato.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Autor;
import br.com.zupacademy.renato.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);
	
}
