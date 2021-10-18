package com.ceiba.biblioteca.domain.model;

import com.ceiba.biblioteca.aplication.dto.request.PrestamoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class Prestamo {

  private Long id;
  private String isbn;
  private String identificacionUsuario;
  private byte tipoUsuario;
  private String fechaMaximaDevolucion;


  public Prestamo() {
    super();
  }

  @Autowired
  private Prestamo(Long id, String isbn, String identificacionUsuario, byte tipoUsuario, String fechaMaximaDevolucion) {
    this.id = id;
    this.isbn = isbn;
    this.identificacionUsuario = identificacionUsuario;
    this.tipoUsuario = tipoUsuario;
    this.fechaMaximaDevolucion = fechaMaximaDevolucion;
  }

  public static Prestamo buildOf(PrestamoRequest prestamoRequest, String fechaMaximaDevolucion) {
    Prestamo prestamo = new Prestamo();
    BeanUtils.copyProperties(prestamoRequest, prestamo);
    prestamo.setFechaMaximaDevolucion(fechaMaximaDevolucion);
    return prestamo;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn){
    this.isbn = isbn;
  }

  public String getIdentificacionUsuario() {
    return identificacionUsuario;
  }
  public void setIdentificacionUsuario(String identificacionUsuario) {
    this.identificacionUsuario = identificacionUsuario;
  }

  public byte getTipoUsuario() {
    return tipoUsuario;
  }
  public void setTipoUsuario( byte tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }


  public String getFechaMaximaDevolucion() {
    return fechaMaximaDevolucion;
  }
  public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
    this.fechaMaximaDevolucion = fechaMaximaDevolucion;
  }

}