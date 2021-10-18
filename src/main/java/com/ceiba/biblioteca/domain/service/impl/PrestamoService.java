package com.ceiba.biblioteca.domain.service.impl;

import com.ceiba.biblioteca.aplication.dto.request.PrestamoRequest;
import com.ceiba.biblioteca.aplication.dto.response.PrestamoResponse;
import com.ceiba.biblioteca.domain.exceptions.Messages;
import com.ceiba.biblioteca.domain.exceptions.PrestamoException;
import com.ceiba.biblioteca.domain.exceptions.core.ResException;
import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.domain.model.TipoUsuario;
import com.ceiba.biblioteca.domain.repository.IPrestamoRepository;
import com.ceiba.biblioteca.domain.service.useCase.IPrestamoService;
import com.ceiba.biblioteca.infrastructure.repository.entity.PrestamoEntity;
import com.ceiba.biblioteca.infrastructure.repository.mapper.PrestamoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class PrestamoService implements IPrestamoService {

    @Autowired
    private IPrestamoRepository repository;

    @Autowired
    private PrestamoMapper mapper;

    @Override
    public PrestamoResponse realizarPrestamo(PrestamoRequest prestamoRequest) throws ResException{

        Prestamo prestamo;

        if(prestamoRequest.getTipoUsuario() == TipoUsuario.USUARIO_INVITADO) {
            esPosiblePrestarLibro(prestamoRequest.getIdentificacionUsuario());
            prestamo = savePrestamo(prestamoRequest, 7);

        } else if (prestamoRequest.getTipoUsuario() == TipoUsuario.USUARIO_AFILIADO) {
            prestamo = savePrestamo(prestamoRequest, 10);

        } else if(prestamoRequest.getTipoUsuario() == TipoUsuario.USUARIO_EMPLEADO) {
            prestamo = savePrestamo(prestamoRequest, 8);

        } else {
            throw new ResException(
                    new PrestamoException(Messages.MESSAGE_USER_TYPE_NOT_ALLOWED)
            );
        }

        return new PrestamoResponse(prestamo.getId(), prestamo.getFechaMaximaDevolucion());
    }

    @Override
    public Prestamo getPrestamoById(Long id) throws ResException {
        PrestamoEntity entity = repository.getPrestamoById(id);
        if(entity != null) {
            return mapper.toDomain(entity);
        }
        throw new ResException(new PrestamoException(Messages.MESSAGE_PRESTAMO_NOT_EXISTING));
    }

    private Prestamo savePrestamo(PrestamoRequest prestamoRequest, int diasHabiles) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Prestamo prestamo = Prestamo.buildOf(prestamoRequest, getFechaMaximaDevolucion(diasHabiles).format(formatoFecha));
        PrestamoEntity entity = repository.savePrestamo(mapper.toEntity(prestamo));
        return mapper.toDomain(entity);
    }

    @Override
    public void esPosiblePrestarLibro(String identificacionUsuario) throws ResException {
        if(repository.getPrestamoByIdentificacionUsuario(identificacionUsuario).size() > 0) {
            throw new ResException(
                    new PrestamoException(Messages.TEXT_THE_USER_WITH_IDENTIFICATION
                            .concat(identificacionUsuario)
                            .concat(Messages.TEXT_USER_HAS_TAKEN_A_BOOK))
            );
        }
    }
    
    private LocalDate getFechaMaximaDevolucion(int diasHabiles) {
        LocalDate date = LocalDate.now();
        int addedDays = 0;
        while (addedDays < diasHabiles) {
            date = date.plusDays(1);
            if (!(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return date;
    }
}
