package com.ceiba.biblioteca.aplication.rest;


import com.ceiba.biblioteca.aplication.dto.request.PrestamoRequest;
import com.ceiba.biblioteca.aplication.dto.response.PrestamoResponse;
import com.ceiba.biblioteca.domain.exceptions.core.ResException;
import com.ceiba.biblioteca.domain.model.Prestamo;
import com.ceiba.biblioteca.domain.service.useCase.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {

  @Autowired
  private IPrestamoService service;

  @GetMapping("/{id-prestamo}")
  public ResponseEntity<?> getPrestamoById(@PathVariable("id-prestamo") Long id) {
      try {
          Prestamo prestamo = service.getPrestamoById(id);
          return new ResponseEntity<>(prestamo, HttpStatus.OK);
      }catch (ResException e) {
          return new ResponseEntity<>(e.getException(), HttpStatus.BAD_REQUEST);
      }catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
  }

  @PostMapping("")
  public ResponseEntity<?> prestar(@RequestBody() PrestamoRequest prestamo) {
      try {
        PrestamoResponse response = service.realizarPrestamo(prestamo);
        return new ResponseEntity<>(response, HttpStatus.OK);
      }catch (ResException e) {
        return new ResponseEntity<>(e.getException(), HttpStatus.BAD_REQUEST);
      }catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
  }

}

