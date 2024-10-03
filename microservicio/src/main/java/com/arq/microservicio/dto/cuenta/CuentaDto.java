package com.arq.microservicio.dto.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Freddy Torres
 * file :  CuentaDto
 * @since : 1/10/2024, mar
 **/

@AllArgsConstructor
@Data
public class CuentaDto {
    private String cuenta;
    private String tipoCuenta;
    private String identificacionCliente;
    private String nombreCliente;
    private String apellidoCliente;
}
