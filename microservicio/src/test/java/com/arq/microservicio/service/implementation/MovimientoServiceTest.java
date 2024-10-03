package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.*;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.repository.IMovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.arq.microservicio.constant.ConstantsProcess.FORMAT_DATE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author : Freddy Torres
 * file :  MovimientoServiceTest
 * @since : 2/10/2024, mié
 **/

@ExtendWith(MockitoExtension.class)
class MovimientoServiceTest {
    @InjectMocks
    private MovimientoService movimientoService;
    @Mock
    private IMovimientoRepository iMovimientoRepository;
    private static final String IDENTIFICACION = "1715789257";
    private static final String FECHA = "2024-10-02";
    SimpleDateFormat formato = new SimpleDateFormat(FORMAT_DATE);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEstadoCuenta_OK() throws ParseException {
        // When
        when(iMovimientoRepository.findByCuentaByFechas(IDENTIFICACION, formato.parse(FECHA), formato.parse(FECHA))).thenReturn(getMovimientoEntity("movimiento"));
        List<MovimientoDto> result = movimientoService.getEstadoCuenta(IDENTIFICACION, FECHA, FECHA);
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void getCuentaByNumero_NO_FOUD() throws ParseException {
        // When
        when(iMovimientoRepository.findByCuentaByFechas(IDENTIFICACION, formato.parse(FECHA), formato.parse(FECHA))).thenReturn(getMovimientoEntity("noMovimiento"));
        // Then
        assertThrows(ResourceNotFoundException.class, () -> movimientoService.getEstadoCuenta(IDENTIFICACION, FECHA, FECHA));
    }

    @Test
    void testGetSaldoDisponible_InsufficientFunds() {
        // Given
        MovimientoEntity movimientoInsuficiente = MovimientoEntity.builder()
                .cuenta(CuentaEntity.builder().numero("123456").build())
                .tipomovimiento(TipoMovimientoEntity.builder().id(1).build())
                .monto(200f)
                .build();
        // When
        when(iMovimientoRepository.findByOrderByFechahoraDesc(any()))
                .thenReturn(List.of(getMovimiento()));
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> movimientoService.saveMovimiento(movimientoInsuficiente));
        // Then
        assertEquals("Saldo no disponible", exception.getMessage());
    }

    static MovimientoEntity getMovimiento() {
        return MovimientoEntity.builder()
                .monto(100f)
                .saldodisponible(100f)
                .tipomovimiento(TipoMovimientoEntity.builder().id(1L).build())
                .cuenta(CuentaEntity.builder().id(1L).build())
                .build();
    }


    static List<MovimientoEntity> getMovimientoEntity(String operacion) {
        List<MovimientoEntity> movimientoEntity = new ArrayList<>();
        if (operacion.equals("movimiento")) {
            movimientoEntity.add(MovimientoEntity.builder()
                    .monto(100f)
                    .saldodisponible(100f)
                    .descripcion("PRUEBA")
                    .tipomovimiento(TipoMovimientoEntity.builder().build())
                    .cuenta(CuentaEntity.builder()
                            .tipoCuenta(TipoCuentaEntity.builder().id(1L).build())
                            .cliente(ClienteEntity.builder().id(1L).build())
                            .build())
                    .build());
        }
        return movimientoEntity;
    }
}
