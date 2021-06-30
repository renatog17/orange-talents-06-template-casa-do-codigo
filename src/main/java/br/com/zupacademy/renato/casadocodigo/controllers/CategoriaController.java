package br.com.zupacademy.renato.casadocodigo.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.renato.casadocodigo.config.validacao.ProibeCategoriaNomeDuplicadoValidator;
import br.com.zupacademy.renato.casadocodigo.controllers.form.CategoriaForm;
import br.com.zupacademy.renato.casadocodigo.model.Categoria;
import br.com.zupacademy.renato.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder) {
		System.out.println("tá chegando aqui");
		Categoria categoria = categoriaForm.toModel();
		categoriaRepository.save(categoria);
		//URI uri = uriBuilder.path("categoria/{id}").buildAndExpand(categoria.getId()).toUri();
		//return ResponseEntity.created(uri).body(categoria);
		return ResponseEntity.ok().build();
	}
}
