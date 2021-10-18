package com.ceiba.biblioteca.infrastructure.repository.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table
public class PrestamoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 10)
  private String isbn;
  @Column(length = 10)
  private String identificacionUsuario;
  @Column()
  private byte tipoUsuario;
  @Column()
  private String fechaMaximaDevolucion;


  public PrestamoEntity() {
    super();
  }

  @Autowired
  public PrestamoEntity(Long id, String isbn, String identificacionUsuario, byte tipoUsuario, String fechaMaximaDevolucion) {
    this.id = id;
    this.isbn = isbn;
    this.identificacionUsuario = identificacionUsuario;
    this.tipoUsuario = tipoUsuario;
    this.fechaMaximaDevolucion = fechaMaximaDevolucion;
  }

  @Autowired
  public PrestamoEntity(String isbn, String identificacionUsuario, byte tipoUsuario, String fechaMaximaDevolucion) {
    this.isbn = isbn;
    this.identificacionUsuario = identificacionUsuario;
    this.tipoUsuario = tipoUsuario;
    this.fechaMaximaDevolucion = fechaMaximaDevolucion;
  }

  public Long getId() {
    return id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
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

  public void setTipoUsuario(byte tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }


  public String getFechaMaximaDevolucion() {
    return fechaMaximaDevolucion;
  }

  public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
    this.fechaMaximaDevolucion = fechaMaximaDevolucion;
  }
}