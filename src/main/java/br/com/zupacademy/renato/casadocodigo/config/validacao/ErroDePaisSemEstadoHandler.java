package br.com.zupacademy.renato.casadocodigo.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDePaisSemEstadoHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErroValidacao handler(IllegalArgumentException exception) {
		ErroValidacao erro = new ErroValidacao("pais", "É necessário escolher um estado para esse país");
		return erro;
	}
}
