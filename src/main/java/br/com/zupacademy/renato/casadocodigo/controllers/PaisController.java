package br.com.zupacademy.renato.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.controllers.form.PaisForm;
import br.com.zupacademy.renato.casadocodigo.model.Pais;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisForm paisForm) {
		Pais pais = paisForm.toModel();
		paisRepository.save(pais);
		return ResponseEntity.ok().build();
	}
}
