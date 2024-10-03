package com.arq.microservicio.repository;

import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author : Freddy Torres
 * file :  IMovimientoRepository
 * @since : 2/10/2024, mié
 **/

@Repository
public interface IMovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    @Query("SELECT u FROM MovimientoEntity u " +
            "left join fetch u.cuenta a " +
            "left join fetch a.cliente b WHERE b.identificacion=:identificacion " +
            "AND u.fecha BETWEEN  :fechainicio AND :fechafin")
    List<MovimientoEntity> findByCuentaByFechas(String identificacion, Date fechainicio, Date fechafin);

    @Query("SELECT u FROM MovimientoEntity u " +
            "left join fetch u.cuenta a " +
            "ORDER BY u.fechahora DESC ")
    List<MovimientoEntity> findByOrderByFechahoraDesc(CuentaEntity cuenta);
}
