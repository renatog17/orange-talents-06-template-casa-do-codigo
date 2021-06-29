package br.com.zupacademy.renato.casadocodigo.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.renato.casadocodigo.config.validacao.ProibeEmailDuplicadoValidator;
import br.com.zupacademy.renato.casadocodigo.controllers.form.AutorForm;
import br.com.zupacademy.renato.casadocodigo.model.Autor;
import br.com.zupacademy.renato.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Autor> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		Autor autor = autorForm.converterFormParaModel();
		autorRepository.save(autor);
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autor);
	}
	
}
