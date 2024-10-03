package com.arq.microservicio.repository;

import com.arq.microservicio.entity.ClienteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Freddy Torres
 * file :  IClienteRepositoryTest
 * @since : 30/9/2024, lun
 **/

class IClienteRepositoryTest {
    @Mock
    private IClienteRepository clienteRepository;

    @InjectMocks
    private ClienteEntity clienteEntity;
    private static final String IDENTIFICACION = "1717703969";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteEntity.setIdentificacion(IDENTIFICACION);
    }

    @Test
    public void findByIdentificacion_OK() {
        // Given
        when(clienteRepository.findByIdentificacion(IDENTIFICACION)).thenReturn(List.of(clienteEntity));
        // When
        List<ClienteEntity> result = clienteRepository.findByIdentificacion(IDENTIFICACION);
        // Then
        assertTrue(!result.isEmpty());
        assertEquals(IDENTIFICACION, result.get(0).getIdentificacion());
    }
}
