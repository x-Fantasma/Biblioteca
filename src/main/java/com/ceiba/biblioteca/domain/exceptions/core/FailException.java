package com.ceiba.biblioteca.domain.exceptions.core;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class FailException {

	private String mensaje;
	
	public FailException() {
		
	}

	@Autowired
	public FailException(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}