package com.arq.microservicio.mapper.movimiento;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.MovimientoEntity;

/**
 * @author : Freddy Torres
 * file :  MovimientoMapper
 * @since : 2/10/2024, mié
 **/

public class MovimientoMapper {
    public static MovimientoDto mapToMovimientoDTO(MovimientoEntity movimiento) {
        return new MovimientoDto(
                movimiento.getFecha(),
                movimiento.getMonto(),
                movimiento.getSaldodisponible(),
                movimiento.getDescripcion(),
                movimiento.getTipomovimiento().getNombre(),
                movimiento.getCuenta().getNumero(),
                movimiento.getCuenta().getTipoCuenta().getNombre(),
                movimiento.getCuenta().getCliente().getNombre(),
                movimiento.getCuenta().getCliente().getApellido(),
                movimiento.getCuenta().getCliente().getIdentificacion()
        );
    }
}
