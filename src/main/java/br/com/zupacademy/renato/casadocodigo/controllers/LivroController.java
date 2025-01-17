package br.com.zupacademy.renato.casadocodigo.controllers;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.controllers.dto.LivroDetalheDto;
import br.com.zupacademy.renato.casadocodigo.controllers.dto.LivroDto;
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
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.toModel(categoriaRepository,autorRepository);
		if(livro==null) {
			return ResponseEntity.badRequest().build();
		}
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public Page<LivroDto> listar(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		Page<Livro> livros = livroRepository.findAll(paginacao);
		return LivroDto.converter(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalheDto> consultar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			LivroDetalheDto livroDetalheDto = new LivroDetalheDto(livro.get());
			return ResponseEntity.ok(livroDetalheDto);
		}
		return ResponseEntity.notFound().build();
	}
}
