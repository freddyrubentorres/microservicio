package com.arq.microservicio.mapper;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.entity.UsuarioEntity;
import com.arq.microservicio.mapper.cliente.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author : Freddy Torres
 * file :  ClienteMapperTest
 * @since : 28/9/2024, sáb
 **/

class ClienteMapperTest {

    ClienteEntity cliente;

    @BeforeEach
    public void setup() {
        cliente = ClienteEntity.builder()
                .id(1L)
                .identificacion("1715789257")
                .nombre("Jose")
                .apellido("Lema")
                .direccion("Otavalo sn y principal")
                .telefono("098254785")
                .genero("M")
                .estado(true)
                .usuario(UsuarioEntity.builder()
                        .email("jlema@gmail.com")
                        .password("ysa31SlWeJfSOEGz1zai3w==")
                        .build())
                .build();
    }


    @Test
    public void testMapToClienteDTO() {
        // When
        ClienteDto clienteDto = ClienteMapper.mapToClienteDTO(cliente);
        // Then
        assertNotNull(clienteDto);
        assertEquals("1715789257", clienteDto.getIdentificacion());
        assertEquals("Jose", clienteDto.getNombre());
        assertEquals("Lema", clienteDto.getApellido());
        assertEquals("Otavalo sn y principal", clienteDto.getDireccion());
        assertEquals("098254785", clienteDto.getTelefono());
        assertEquals("M", clienteDto.getGenero());
        assertEquals(true, clienteDto.getEstado());
        assertEquals("jlema@gmail.com", cliente.getUsuario().getEmail());
        assertEquals("ysa31SlWeJfSOEGz1zai3w==", cliente.getUsuario().getPassword());
    }
}
