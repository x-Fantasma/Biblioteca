package com.ceiba.biblioteca.aplication.dto.response;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class PrestamoResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1023407711011767076L;

    private Long id;
    private String fechaMaximaDevolucion;

    public PrestamoResponse() {

    }

    @Autowired
    public PrestamoResponse(Long id, String fechaMaximaDevolucion) {
        this.id = id;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
