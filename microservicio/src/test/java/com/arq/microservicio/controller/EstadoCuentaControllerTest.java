package com.arq.microservicio.controller;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.service.implementation.MovimientoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  EstadoCuentaControllerTest
 * @since : 2/10/2024, mié
 **/

@ExtendWith(MockitoExtension.class)
class EstadoCuentaControllerTest {
    @InjectMocks
    private CuentaController cuentaController;
    @Mock
    private MovimientoService movimientoService;

    MovimientoDto movimientoDto;

    private static final String IDENTIFICACION = "225487";
    private static final String FECHA = "2024-10-02";
    @BeforeEach
    public void setup() {
        movimientoDto=MovimientoDto.builder()
                .fecha(new Date())
                .monto(100)
                .saldoDisponible(100)
                .descripcion("APERTUTA DE CUENTA")
                .tipoMovimiento("DEPOSITO")
                .numeroCuenta("495879")
                .tipoCuenta("CORRIENTE")
                .nombre("JOSE")
                .apellido("LEMA")
                .identificacion(IDENTIFICACION)
                .build();
    }

    @Test
    public void getEstadoCuenta_OK() throws ParseException {
        // Given
        List<MovimientoDto> movimiento = Collections.singletonList(movimientoDto);
        // When
        when(movimientoService.getEstadoCuenta(IDENTIFICACION,FECHA,FECHA)).thenReturn(movimiento);
        ResponseEntity<Object> response = cuentaController.getEstadoCuenta(IDENTIFICACION,FECHA,FECHA);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
