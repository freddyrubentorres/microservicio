package com.arq.microservicio.controller;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.service.implementation.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  CuentaControllerTest
 * @since : 1/10/2024, mar
 **/
@ExtendWith(MockitoExtension.class)
class CuentaControllerTest {

    @InjectMocks
    private CuentaController cuentaController;
    @Mock
    private CuentaService cuentaService;
    private static final String NUMERO = "225487";

    CuentaDto cuentaDto;
    CuentaEntity cuentaEntity;

    @BeforeEach
    public void setup() {
        cuentaDto = new CuentaDto(
                "225487",
                "1",
                "1",
                "JUAN",
                "PEREZ"
        );
        cuentaEntity = CuentaEntity.builder().build();
    }


    @Test
    public void getCuentaByNumero_OK() {
        // Given
        List<CuentaDto> clientes = Collections.singletonList(cuentaDto);
        // When
        when(cuentaService.getCuentaByNumero(NUMERO)).thenReturn(clientes);
        ResponseEntity<Object> response = cuentaController.getCuentaByNumero(NUMERO);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void postCuenta_OK() {
        // When
        ResponseEntity<Object> response = cuentaController.postCuenta(cuentaEntity);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void putCuenta_OK() {
        // When
        ResponseEntity<Object> response = cuentaController.putCuenta(cuentaEntity);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
