package com.arq.microservicio.mapper.cuenta;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.CuentaEntity;

/**
 * @author : Freddy Torres
 * file :  CuentaMapper
 * @since : 1/10/2024, mar
 **/

public class CuentaMapper {
    public static CuentaDto mapToCuentaDTO(CuentaEntity cuenta) {
        return
                CuentaDto.builder()
                        .cuenta(cuenta.getNumero())
                        .tipoCuenta(cuenta.getTipoCuenta().getNombre())
                        .identificacionCliente(cuenta.getCliente().getIdentificacion())
                        .nombreCliente(cuenta.getCliente().getNombre())
                        .apellidoCliente(cuenta.getCliente().getApellido())
                        .build();
    }
}
