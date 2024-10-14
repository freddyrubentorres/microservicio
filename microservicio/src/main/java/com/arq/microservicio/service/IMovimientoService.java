package com.arq.microservicio.service;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.MovimientoEntity;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author : Freddy Torres
 * file :  IMovimientoService
 * @since : 2/10/2024, mié
 **/

public interface IMovimientoService {
    List<MovimientoDto> getEstadoCuenta(String identificacion, String fechainicio, String fechafin) throws ParseException;

    MovimientoEntity saveMovimiento(MovimientoEntity cuentaEntity);
}
