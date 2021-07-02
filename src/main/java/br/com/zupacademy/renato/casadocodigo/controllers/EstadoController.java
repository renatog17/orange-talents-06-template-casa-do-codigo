package br.com.zupacademy.renato.casadocodigo.controllers;

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

import br.com.zupacademy.renato.casadocodigo.config.validacao.ProibeEstadoDuplicadoParaPaisValidator;
import br.com.zupacademy.renato.casadocodigo.controllers.form.EstadoForm;
import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	PaisRepository paisRepository;
	@Autowired
	ProibeEstadoDuplicadoParaPaisValidator proibeEstadoDuplicadoParaPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(proibeEstadoDuplicadoParaPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoForm estadoForm) {
		Estado estado = estadoForm.toModel(paisRepository);
		estadoRepository.save(estado);
		return ResponseEntity.ok().build();
	}
}
