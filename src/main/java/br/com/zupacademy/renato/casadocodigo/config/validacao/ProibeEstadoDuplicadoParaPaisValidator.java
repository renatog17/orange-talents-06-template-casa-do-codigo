package br.com.zupacademy.renato.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.renato.casadocodigo.controllers.form.EstadoForm;
import br.com.zupacademy.renato.casadocodigo.model.Estado;
import br.com.zupacademy.renato.casadocodigo.model.Pais;
import br.com.zupacademy.renato.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.renato.casadocodigo.repository.PaisRepository;

@Component
public class ProibeEstadoDuplicadoParaPaisValidator implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		EstadoForm estadoForm = (EstadoForm) target;
		Optional<Pais> possivelPais = paisRepository.findById(estadoForm.getIdPais());
		Optional<Estado> possivelEstado = estadoRepository.findByNomeAndPais(estadoForm.getNome(), possivelPais.get());
		if(possivelEstado.isPresent()) {
			errors.rejectValue("Nome", null, "Já existe o estado "+estadoForm.getNome()+" no país "+possivelPais.get().getNome());
		}
	}

	

}
