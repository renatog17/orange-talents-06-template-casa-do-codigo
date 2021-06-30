package br.com.zupacademy.renato.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renato.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
