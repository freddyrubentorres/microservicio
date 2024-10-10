package com.arq.microservicio.controller;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.service.implementation.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  ClienteControllerTest
 * @since : 27/9/2024, vie
 **/

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;
    @Mock
    private ClienteService clienteService;

    private static final String IDENTIFICACION = "1717703969";
    private static final Long ID_CLIENTE = 1L;

    ClienteDto clienteDto;
    ClienteEntity clienteEntity;

    @BeforeEach
    public void setup() {
        clienteDto=ClienteDto.builder()
                .identificacion("1715789257")
                .nombre("Jose")
                .apellido("Lema")
                .direccion("Otavalo sn y principal")
                .telefono("098254785")
                .genero("M")
                .estado(true)
                .email("jlema@gmail.com")
                .pasword("ysa31SlWeJfSOEGz1zai3w==")
                .build();
        clienteEntity = ClienteEntity.builder()
                .build();
    }

    @Test
    public void getClientes_OK() {
        // Given
        List<ClienteDto> clientes = Collections.singletonList(clienteDto);
        // When
        when(clienteService.getClientes()).thenReturn(clientes);
        ResponseEntity<Object> response = clienteController.getCliente();
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getClienteByIdentificacion_OK() {
        // Given
        List<ClienteDto> clientes = Collections.singletonList(clienteDto);
        // When
        when(clienteService.getClientesByIdentificacion(IDENTIFICACION)).thenReturn(clientes);
        ResponseEntity<Object> response = clienteController.getClienteByIdentificacion(IDENTIFICACION);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void postCliente_OK() {
        // When
        ResponseEntity<Object> response = clienteController.postCliente(clienteEntity);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteClienteCliente_OK() {
        // When
        ResponseEntity<Object> response = clienteController.deleteCliente(ID_CLIENTE);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void putCliente_OK() {
        // When
        ResponseEntity<Object> response = clienteController.putCliente(clienteEntity);
        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
