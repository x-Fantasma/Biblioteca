package com.ceiba.biblioteca.domain.service.useCase;

import com.ceiba.biblioteca.aplication.dto.request.PrestamoRequest;
import com.ceiba.biblioteca.aplication.dto.response.PrestamoResponse;
import com.ceiba.biblioteca.domain.exceptions.core.ResException;
import com.ceiba.biblioteca.domain.model.Prestamo;

public interface IPrestamoService {

    PrestamoResponse realizarPrestamo(PrestamoRequest prestamoRequest) throws ResException;
    Prestamo getPrestamoById(Long id) throws ResException;
    void esPosiblePrestarLibro(String identificacionUsuario) throws ResException;

}
