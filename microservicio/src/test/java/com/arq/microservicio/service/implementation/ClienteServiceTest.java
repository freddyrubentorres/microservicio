package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.entity.UsuarioEntity;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.repository.IClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  ClienteServiceTest
 * @since : 28/9/2024, sáb
 **/
@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
    @Mock
    private IClienteRepository iClienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    void testGetClientes() {
        // When
        when(iClienteRepository.findAll()).thenReturn(Collections.singletonList(getClienteEntity()));
        List<ClienteDto> result = clienteService.getClientes();
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iClienteRepository).findAll();
    }*/

    @Test
    void testGetClientesByIdentificacionFound() {
        // When
        when(iClienteRepository.findByIdentificacion("12345678")).thenReturn(Collections.singletonList(getClienteEntity()));
        List<ClienteDto> result = clienteService.getClientesByIdentificacion("12345678");
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iClienteRepository).findByIdentificacion("12345678");
    }

    @Test
    void testGetClientesByIdentificacionNotFound() {
        // When
        when(iClienteRepository.findByIdentificacion("12345678")).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> clienteService.getClientesByIdentificacion("12345678"));
        // Then
        assertEquals("Cliente con identificacion : 12345678, no  encontrado.", exception.getMessage());
    }

    @Test
    void testSaveCliente() {
        // When
        when(iClienteRepository.save(any(ClienteEntity.class))).thenReturn(getClienteEntity());
        ClienteEntity result = clienteService.saveCliente(getClienteEntity());
        // Then
        assertNotNull(result);
    }

    @Test
    void testDeleteClienteFound() {
        // When
        when(iClienteRepository.findById(1L)).thenReturn(Optional.of(getClienteEntity()));
        boolean result = clienteService.deleteCliente(1L);
        // Then
        assertTrue(result);
        verify(iClienteRepository).deleteById(1L);
    }

    @Test
    void testDeleteClienteNotFound() {
        // When
        when(iClienteRepository.findById(1L)).thenReturn(Optional.empty());
        // Then
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> clienteService.deleteCliente(1L));
        assertEquals("Cliente con id : 1, no  encontrado.", exception.getMessage());
    }

    @Test
    void testPutClienteFound() {
        // When
        when(iClienteRepository.findById(1L)).thenReturn(Optional.of(getClienteEntity()));
        when(iClienteRepository.save(any(ClienteEntity.class))).thenReturn(getClienteEntity());
        ClienteEntity result = clienteService.putCliente(getClienteEntity());
        // Then
        assertNotNull(result);
    }

    @Test
    public void putCliente_NO_FOUND() {
        // When
        when(iClienteRepository.findById(1L)).thenReturn(Optional.empty());
        // Then
        assertThrows(ResourceNotFoundException.class, () -> clienteService.putCliente(getClienteEntity()));
    }

    static ClienteEntity getClienteEntity() {
        return ClienteEntity.builder()
                .id(1l)
                .identificacion("1715478418")
                .usuario(UsuarioEntity.builder().email("email@gmail.com").build())
                .build();
    }
}
