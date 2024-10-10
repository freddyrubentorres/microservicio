package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.TipoCuentaEntity;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.repository.ICuentaRepository;
import com.arq.microservicio.repository.IMovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  CuentaServiceTest1
 * @since : 2/10/2024, mié
 **/

class CuentaServiceTest {
    @Mock
    private ICuentaRepository iCuentaRepository;

    @Mock
    private IMovimientoRepository iMovimientoRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCuentaByNumeroFound() {
        when(iCuentaRepository.findByNumeroAndEstadoTrue("123456")).thenReturn(Collections.singletonList(getCuentaEntity()));
        List<CuentaDto> result = cuentaService.getCuentaByNumero("123456");
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iCuentaRepository).findByNumeroAndEstadoTrue("123456");
    }

    @Test
    void testGetCuentaByNumeroNotFound() {
        when(iCuentaRepository.findByNumeroAndEstadoTrue("123456")).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> cuentaService.getCuentaByNumero("123456"));
        assertEquals("Numero de cuenta : 123456, no  encontrado, o esta inactiva", exception.getMessage());
    }

    @Test
    void testSaveCuenta() {
        when(iCuentaRepository.save(any(CuentaEntity.class))).thenReturn(getCuentaEntity());
        when(iMovimientoRepository.save(any())).thenReturn(null);
        CuentaEntity result = cuentaService.saveCuenta(getCuentaEntity());
        assertNotNull(result);
        verify(iMovimientoRepository).save(any());
    }

    @Test
    void testPutCuentaFound() {
        when(iCuentaRepository.findById(1L)).thenReturn(Optional.of(getCuentaEntity()));
        when(iCuentaRepository.save(any(CuentaEntity.class))).thenReturn(getCuentaEntity());
        CuentaEntity result = cuentaService.putCuenta(getCuentaEntity());
        assertNotNull(result);
        verify(iCuentaRepository).findById(1L);
    }

    @Test
    void testPutCuentaNotFound() {
        when(iCuentaRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> cuentaService.putCuenta(getCuentaEntity()));
        assertEquals("Cuenta con id : 1, no  encontrado.", exception.getMessage());
    }

    static CuentaEntity getCuentaEntity() {
        return CuentaEntity.builder()
                .id(1L)
                .numero("123456")
                .estado(true)
                .montoinicial(1000.0f)
                .cliente(ClienteEntity.builder().identificacion("1748527847").build())
                .tipoCuenta(TipoCuentaEntity.builder().nombre("AHORRO").build())
                .build();
    }
}
