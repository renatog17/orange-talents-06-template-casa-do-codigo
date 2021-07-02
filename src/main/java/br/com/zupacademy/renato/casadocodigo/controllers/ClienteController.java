package br.com.zupacademy.renato.casadocodigo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.controllers.form.ClienteForm;
import br.com.zupacademy.renato.casadocodigo.model.Cliente;
import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.renato.casadocodigo.repository.EnderecoRepository;
import br.com.zupacademy.renato.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	PaisRepository paisRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@GetMapping
	public ResponseEntity<?> teste() {
		boolean exist = estadoRepository.existsByPais(paisRepository.findById(4L).get());
		if(exist) {
			System.out.println("existe estado para essa país");
		}else {
			System.out.println("Não existe estado para ess país");
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteForm clienteForm){
		Cliente cliente = clienteForm.toModel(paisRepository, estadoRepository);
		enderecoRepository.save(cliente.getEndereco());
		clienteRepository.save(cliente);
		return ResponseEntity.ok().build();
	}
	
}
