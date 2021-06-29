package br.com.zupacademy.renato.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.renato.casadocodigo.controllers.form.CategoriaForm;
import br.com.zupacademy.renato.casadocodigo.model.Categoria;
import br.com.zupacademy.renato.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeCategoriaNomeDuplicadoValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaForm categoriaForm = (CategoriaForm) target;
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaForm.getNome());
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("Nome", null, "Já existe uma categoria cadastrado com esse nome "+possivelCategoria.get().getNome());
		}
	}

}
