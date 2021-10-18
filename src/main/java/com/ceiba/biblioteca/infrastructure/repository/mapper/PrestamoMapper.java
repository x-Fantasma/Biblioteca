package com.ceiba.biblioteca.infrastructure.repository.mapper;

import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class PrestamoMapper {

    public Prestamo toDomain(PrestamoEntity entity) {
        Prestamo prestamo = new Prestamo();
        BeanUtils.copyProperties(entity, prestamo);
        return prestamo;
    }

    public PrestamoEntity toEntity(Prestamo prestamo) {
        PrestamoEntity entity = new PrestamoEntity();
        BeanUtils.copyProperties(prestamo, entity);
        return entity;
    }
}
