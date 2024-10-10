package com.arq.microservicio.dto.movimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author : Freddy Torres
 * file :  MovimientoDto
 * @since : 2/10/2024, mié
 **/
@AllArgsConstructor
@Data
@Builder
public class MovimientoDto {
    private Date fecha;
    private float monto;
    private float saldoDisponible;
    private String descripcion;
    private String tipoMovimiento;
    private String numeroCuenta;
    private String tipoCuenta;
    private String nombre;
    private String apellido;
    private String identificacion;
}
