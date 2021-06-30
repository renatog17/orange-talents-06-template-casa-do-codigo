package br.com.zupacademy.renato.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.controllers.form.LivroForm;
import br.com.zupacademy.renato.casadocodigo.model.Livro;
import br.com.zupacademy.renato.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.renato.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.renato.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroRepository livroRepository; 
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm livroForm){
		System.out.println(livroForm.toString());
		Livro livro = livroForm.toModel(categoriaRepository,autorRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
}
