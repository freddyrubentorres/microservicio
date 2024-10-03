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
        return new CuentaDto(cuenta.getNumero()
                , cuenta.getTipoCuenta().getNombre()
                , cuenta.getCliente().getIdentificacion()
                , cuenta.getCliente().getNombre()
                , cuenta.getCliente().getApellido()
        );
    }
}
