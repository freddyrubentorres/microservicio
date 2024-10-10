package com.arq.microservicio.mapper;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.*;
import com.arq.microservicio.mapper.movimiento.MovimientoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author : Freddy Torres
 * file :  MovimientoMapperTest
 * @since : 2/10/2024, mié
 **/

class MovimientoMapperTest {

    MovimientoEntity movimiento;
    private static final float MONTO = 100f;

    @BeforeEach
    public void setup() {
        movimiento=MovimientoEntity.builder()
                .monto(MONTO)
                .saldodisponible(MONTO)
                .tipomovimiento(TipoMovimientoEntity.builder().build())
                .cuenta(CuentaEntity.builder()
                        .tipoCuenta(TipoCuentaEntity.builder().build())
                        .cliente(ClienteEntity.builder().build())
                        .build())
                .build();
    }

    @Test
    public void mapToMovimientoDTO_OK() {
        // When
        MovimientoDto movimientoDto = MovimientoMapper.mapToMovimientoDTO(movimiento);
        // Then
        assertNotNull(movimientoDto);
        assertEquals(MONTO, movimientoDto.getMonto());
    }
}
