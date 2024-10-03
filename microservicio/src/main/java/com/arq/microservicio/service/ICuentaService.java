package com.arq.microservicio.service;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.CuentaEntity;

import java.util.List;

/**
 * @author : Freddy Torres
 * file :  ICuentaService
 * @since : 1/10/2024, mar
 **/

public interface ICuentaService {
    List<CuentaDto> getCuentaByNumero(String numero);

    CuentaEntity saveCuenta(CuentaEntity cuentaEntity);

    CuentaEntity putCuenta(CuentaEntity cuentaEntity);
}
