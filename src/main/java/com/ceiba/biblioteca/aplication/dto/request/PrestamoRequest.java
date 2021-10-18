package com.ceiba.biblioteca.aplication.dto.request;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PrestamoRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -1568004450774239831L;


  private String isbn;
  private String identificacionUsuario;
  private byte tipoUsuario;

  public PrestamoRequest() {

  }

  @Autowired
  public PrestamoRequest(String isbn, String identificacionUsuario, byte tipoUsuario) {
    this.isbn = isbn;
    this.identificacionUsuario = identificacionUsuario;
    this.tipoUsuario = tipoUsuario;
  }

  public String getIsbn() {
    return isbn;
  }
  public String getIdentificacionUsuario() {
    return identificacionUsuario;
  }
  public byte getTipoUsuario() {
    return tipoUsuario;
  }

}