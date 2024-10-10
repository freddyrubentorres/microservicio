package com.arq.microservicio.mapper.cliente;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;

/**
 * @author : Freddy Torres
 * file :  ClienteMapper
 * @since : 27/9/2024, vie
 **/

public class ClienteMapper {
    public static ClienteDto mapToClienteDTO(ClienteEntity cliente) {
        return ClienteDto.builder()
                .identificacion(cliente.getIdentificacion())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .genero(cliente.getGenero())
                .estado(cliente.getEstado())
                .email(cliente.getUsuario().getEmail())
                .pasword(cliente.getUsuario().getPassword())
                .build();
    }
}
