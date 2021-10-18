package com.ceiba.biblioteca.domain.exceptions;

import com.ceiba.biblioteca.domain.exceptions.core.FailException;
import org.springframework.beans.factory.annotation.Autowired;

public class PrestamoException extends FailException {

	public PrestamoException() { }

	@Autowired
	public PrestamoException(String mensaje) {
		super(mensaje);
	}
}
