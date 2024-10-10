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
        return
                MovimientoDto.builder()
                        .fecha(movimiento.getFecha())
                        .monto(movimiento.getMonto())
                        .saldoDisponible(movimiento.getSaldodisponible())
                        .descripcion(movimiento.getDescripcion())
                        .tipoMovimiento(movimiento.getTipomovimiento().getNombre())
                        .numeroCuenta(movimiento.getCuenta().getNumero())
                        .tipoCuenta(movimiento.getCuenta().getTipoCuenta().getNombre())
                        .nombre(movimiento.getCuenta().getCliente().getNombre())
                        .apellido(movimiento.getCuenta().getCliente().getApellido())
                        .identificacion(movimiento.getCuenta().getCliente().getIdentificacion())
                        .build();
    }
}
