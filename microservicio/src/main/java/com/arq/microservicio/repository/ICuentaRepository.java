package com.arq.microservicio.repository;

import com.arq.microservicio.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Freddy Torres
 * file :  ICuentaRepository
 * @since : 1/10/2024, mar
 **/
@Repository
public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {
    List<CuentaEntity> findByNumeroAndEstadoTrue(String cuenta);
}
