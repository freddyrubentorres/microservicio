package com.arq.microservicio.mapper;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.TipoCuentaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.arq.microservicio.mapper.cuenta.CuentaMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author : Freddy Torres
 * file :  CuentaMapperTest
 * @since : 1/10/2024, mar
 **/

class CuentaMapperTest {
    CuentaEntity cuenta;

    @BeforeEach
    public void setup() {
        cuenta=CuentaEntity.builder()
                .tipoCuenta(TipoCuentaEntity.builder()
                        .id(1L)
                        .nombre("AHORRO")
                        .build())
                .cliente(ClienteEntity.builder()
                        .identificacion("1715784587")
                        .build())
                .build();
    }

    @Test
    public void mapToCuentaDTO() {
        // When
        CuentaDto cuentaDto = CuentaMapper.mapToCuentaDTO(cuenta);
        // Then
        assertNotNull(cuentaDto);
        assertEquals("1715784587", cuentaDto.getIdentificacionCliente());
    }
}
