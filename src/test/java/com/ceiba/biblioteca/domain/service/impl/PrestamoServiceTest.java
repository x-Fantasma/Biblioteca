package com.ceiba.biblioteca.domain.service.impl;

import com.ceiba.biblioteca.domain.exceptions.core.ResException;
import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;
import com.ceiba.biblioteca.infrastructure.repository.repo.PrestamoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PrestamoServiceTest {

    @Mock
    private PrestamoRepository repository;

    @InjectMocks
    private PrestamoService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void esPosiblePrestarLibroUsuarioInvitadoDeberiaRechazarloLanzarUnaExcepcion() {
        String identificacionUsuario = "7481545";
        List<PrestamoEntity> prestamos= new ArrayList<>();
        prestamos.add(new PrestamoEntity());
        when(repository.getPrestamoByIdentificacionUsuario(identificacionUsuario)).thenReturn(prestamos);

        ResException exception = assertThrows(ResException.class, () -> service.esPosiblePrestarLibro(identificacionUsuario));

        verify(repository).getPrestamoByIdentificacionUsuario(identificacionUsuario);
        assertFalse(exception.getException().getMensaje().isEmpty());
    }
}