package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.MovimientoEntity;
import com.arq.microservicio.entity.TipoMovimientoEntity;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.mapper.cuenta.CuentaMapper;
import com.arq.microservicio.repository.ICuentaRepository;
import com.arq.microservicio.repository.IMovimientoRepository;
import com.arq.microservicio.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.arq.microservicio.constant.ConstantsProcess.*;

/**
 * @author : Freddy Torres
 * file :  CuentaService
 * @since : 1/10/2024, mar
 **/

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    ICuentaRepository iCuentaRepository;
    @Autowired
    IMovimientoRepository iMovimientoRepository;

    @Override
    public List<CuentaDto> getCuentaByNumero(String numero) {
        List<CuentaEntity> cuentaEntity = iCuentaRepository.findByNumeroAndEstadoTrue(numero);
        if (cuentaEntity.isEmpty()) {
            throw new ResourceNotFoundException("Numero de cuenta : " + numero + ", no  encontrado, o esta inactiva");
        }
        return cuentaEntity.stream().map(CuentaMapper::mapToCuentaDTO).collect(Collectors.toList());
    }

    @Override
    public CuentaEntity saveCuenta(CuentaEntity cuentaEntity) {
        CuentaEntity createdCuenta = iCuentaRepository.save(cuentaEntity);
        if (createdCuenta.getEstado()) {
            iMovimientoRepository.save(MovimientoEntity.builder()
                    .fecha(new Date())
                    .fechahora(new Date())
                    .monto(createdCuenta.getMontoinicial())
                    .saldodisponible(createdCuenta.getMontoinicial())
                    .descripcion(APERTURA_CUENTA_DESC)
                    .tipomovimiento(TipoMovimientoEntity.builder()
                            .id(ID_DEPOSITO)
                            .build())
                    .cuenta(CuentaEntity.builder()
                            .id(createdCuenta.getId())
                            .build())
                    .build());
        }
        return createdCuenta;
    }

    @Override
    public CuentaEntity putCuenta(CuentaEntity cuentaEntity) {
        Optional<CuentaEntity> cuenta = iCuentaRepository.findById(cuentaEntity.getId());
        if (cuenta.isEmpty()) {
            throw new ResourceNotFoundException("Cuenta con id : " + cuentaEntity.getId() + ", no  encontrado.");
        }
        return iCuentaRepository.save(cuentaEntity);
    }
}
