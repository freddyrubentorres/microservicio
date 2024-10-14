package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.MovimientoEntity;
import com.arq.microservicio.entity.TipoMovimientoEntity;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.mapper.movimiento.MovimientoMapper;
import com.arq.microservicio.repository.IMovimientoRepository;
import com.arq.microservicio.service.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.arq.microservicio.constant.ConstantsProcess.*;

/**
 * @author : Freddy Torres
 * file :  MovimientoService
 * @since : 2/10/2024, mié
 **/

@Service
public class MovimientoService implements IMovimientoService {

    @Autowired
    IMovimientoRepository iMovimientoRepository;

    @Override
    public List<MovimientoDto> getEstadoCuenta(String identificacion, String fechainicio, String fechafin) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat(FORMAT_DATE);
        List<MovimientoEntity> movimientoEntity = iMovimientoRepository.findByCuentaByFechas(identificacion, formato.parse(fechainicio), formato.parse(fechafin));
        if (movimientoEntity.isEmpty()) {
            throw new ResourceNotFoundException("No se encuentra información para los parámetros ingresados.");
        }
        return movimientoEntity.stream().map(MovimientoMapper::mapToMovimientoDTO).collect(Collectors.toList());
    }

    @Override
    public MovimientoEntity saveMovimiento(MovimientoEntity movimientoEntity) {
        List<MovimientoEntity> movimientos = iMovimientoRepository.findByOrderByFechahoraDesc(movimientoEntity.getCuenta());
        float saldoDisponible = getSaldoDisponible(movimientoEntity, movimientos);
        MovimientoEntity nuevoMovimiento = MovimientoEntity.builder()
                .fecha(new Date())
                .monto(movimientoEntity.getMonto())
                .descripcion(movimientoEntity.getDescripcion())
                .cuenta(CuentaEntity.builder().id(movimientoEntity.getCuenta().getId()).build())
                .tipomovimiento(TipoMovimientoEntity.builder().id(movimientoEntity.getTipomovimiento().getId()).build())
                .saldodisponible(saldoDisponible)
                .fechahora(new Date())
                .build();
        return iMovimientoRepository.save(nuevoMovimiento);
    }

    private static float getSaldoDisponible(MovimientoEntity movimientoEntity, List<MovimientoEntity> movimientos) {
        if (movimientos.isEmpty()) {
            throw new ResourceNotFoundException("Cuenta: " + movimientoEntity.getCuenta().getNumero() + " no encontrado.");
        }

        MovimientoEntity movimientoActual = movimientos.get(0);
        float saldoDisponible = movimientoActual.getSaldodisponible();

        if (movimientoEntity.getMonto() < 0) {
            throw new ResourceNotFoundException("Monto no puede ser menor a 0: " + movimientoEntity.getMonto());
        }

        if (movimientoEntity.getTipomovimiento().getId() == 1) {
            if (movimientoEntity.getMonto() > saldoDisponible) {
                throw new ResourceNotFoundException("Saldo no disponible");
            }
            saldoDisponible -= movimientoEntity.getMonto();
        } else {
            saldoDisponible += movimientoEntity.getMonto();
        }
        return saldoDisponible;
    }
}
