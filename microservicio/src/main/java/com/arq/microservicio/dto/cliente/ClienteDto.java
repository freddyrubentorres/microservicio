package com.arq.microservicio.dto.cliente;

import com.arq.microservicio.dto.usuario.UsuarioDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author : Freddy Torres
 * file :  ClienteDTO
 * @since : 27/9/2024, vie
 **/
@AllArgsConstructor
@Data
@SuperBuilder
public class ClienteDto extends UsuarioDto {
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String genero;
    private Boolean estado;
}