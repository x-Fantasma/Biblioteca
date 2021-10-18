package com.ceiba.biblioteca.infrastructure.repository.repo;

import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepositoryDB extends JpaRepository<PrestamoEntity, Long> {

    List<PrestamoEntity> findByIdentificacionUsuario(String identificacionUsuario);

}
