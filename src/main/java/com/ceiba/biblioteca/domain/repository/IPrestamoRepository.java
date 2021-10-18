package com.ceiba.biblioteca.domain.repository;

import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;

import java.util.List;

public interface IPrestamoRepository {

    PrestamoEntity savePrestamo(PrestamoEntity prestamoEntity);
    List<PrestamoEntity> getPrestamoByIdentificacionUsuario(String identificacionUsuario);
    PrestamoEntity getPrestamoById(Long id);
}
