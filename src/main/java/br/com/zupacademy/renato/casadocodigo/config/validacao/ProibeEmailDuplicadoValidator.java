package br.com.zupacademy.renato.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import br.com.zupacademy.renato.casadocodigo.controllers.form.AutorForm;
import br.com.zupacademy.renato.casadocodigo.model.Autor;
import br.com.zupacademy.renato.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorForm autorForm = (AutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(autorForm.getEmail());
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um autor(a) cadastrado para esse email "+possivelAutor.get().getEmail());
		}
	}

}
