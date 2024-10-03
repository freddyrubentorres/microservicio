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

    UsuarioEntity usuario;
    ClienteEntity cliente;

    @BeforeEach
    public void setup() {
        usuario = new UsuarioEntity();
        cliente = new ClienteEntity();
        usuario.setEmail("jlema@gmail.com");
        usuario.setPassword("ysa31SlWeJfSOEGz1zai3w==");
        cliente.setUsuario(usuario);
        cliente.setIdentificacion("1715789257");
        cliente.setNombre("Jose");
        cliente.setApellido("Lema");
        cliente.setDireccion("Otavalo sn y principal");
        cliente.setTelefono("098254785");
        cliente.setGenero("M");
        cliente.setEstado(true);

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
