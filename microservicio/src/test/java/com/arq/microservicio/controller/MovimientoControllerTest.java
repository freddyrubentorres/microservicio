package com.arq.microservicio.controller;

import com.arq.microservicio.entity.MovimientoEntity;
import com.arq.microservicio.service.implementation.MovimientoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  MovimientoControllerTest
 * @since : 2/10/2024, mié
 **/

@ExtendWith(MockitoExtension.class)
class MovimientoControllerTest {
    @InjectMocks
    private CuentaController cuentaController;
    @Mock
    private MovimientoService movimientoService;

    @Test
    public void postMovimiento_OK() {
        // When
        when(movimientoService.saveMovimiento(Mockito.any())).thenReturn(getMovimientoEntity());
        ResponseEntity<Object> response = cuentaController.postMovimiento(getMovimientoEntity());
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    static MovimientoEntity getMovimientoEntity() {
        return new MovimientoEntity();
    }
}
