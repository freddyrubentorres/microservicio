package com.arq.microservicio.dto.usuario;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author : Freddy Torres
 * file :  UsuarioDto
 * @since : 11/10/2024, vie
 **/


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UsuarioDto {
    private String email;
    private String pasword;
}
