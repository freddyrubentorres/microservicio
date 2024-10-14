package com.arq.microservicio.mapper.movimiento;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.MovimientoEntity;

/**
 * @author : Freddy Torres
 * file :  MovimientoMapper
 * @since : 2/10/2024, mié
 **/

public class MovimientoMapper {
    public static MovimientoDto mapToMovimientoDTO(MovimientoEntity movimientoEntity) {
        return
                MovimientoDto.builder()
                        .fecha(movimientoEntity.getFecha())
                        .monto(movimientoEntity.getMonto())
                        .saldoDisponible(movimientoEntity.getSaldodisponible())
                        .descripcion(movimientoEntity.getDescripcion())
                        .tipoMovimiento(movimientoEntity.getTipomovimiento().getNombre())
                        .numeroCuenta(movimientoEntity.getCuenta().getNumero())
                        .tipoCuenta(movimientoEntity.getCuenta().getTipoCuenta().getNombre())
                        .nombre(movimientoEntity.getCuenta().getCliente().getNombre())
                        .apellido(movimientoEntity.getCuenta().getCliente().getApellido())
                        .identificacion(movimientoEntity.getCuenta().getCliente().getIdentificacion())
                        .build();
    }
}
