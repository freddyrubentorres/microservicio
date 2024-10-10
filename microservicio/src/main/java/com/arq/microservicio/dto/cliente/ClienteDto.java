package com.arq.microservicio.dto.cliente;

import lombok.*;

/**
 * @author : Freddy Torres
 * file :  ClienteDTO
 * @since : 27/9/2024, vie
 **/
@AllArgsConstructor
@Data
@Builder
public class ClienteDto {
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String genero;
    private Boolean estado;
    private String email;
    private String pasword;
}