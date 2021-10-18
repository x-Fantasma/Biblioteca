package com.ceiba.biblioteca.infrastructure.repository.repo;

import com.ceiba.biblioteca.domain.repository.IPrestamoRepository;
import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class PrestamoRepository implements IPrestamoRepository {

    @Autowired
    private PrestamoRepositoryDB repo;

    @Override
    public PrestamoEntity savePrestamo(PrestamoEntity prestamoEntity) {
        return repo.save(prestamoEntity);
    }

    @Override
    public List<PrestamoEntity> getPrestamoByIdentificacionUsuario(String identificacionUsuario) {
        return repo.findByIdentificacionUsuario(identificacionUsuario);
    }

    @Override
    public PrestamoEntity getPrestamoById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
