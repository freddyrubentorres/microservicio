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
        return new ClienteDto(cliente.getIdentificacion()
                , cliente.getNombre()
                , cliente.getApellido()
                , cliente.getDireccion()
                , cliente.getTelefono()
                , cliente.getGenero()
                , cliente.getEstado()
                , cliente.getUsuario().getEmail()
                , cliente.getUsuario().getPassword()
        );
    }
}
