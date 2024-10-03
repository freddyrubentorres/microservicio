package com.arq.microservicio.repository;

import com.arq.microservicio.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Freddy Torres
 * file :  IClienteRepository
 * @since : 27/9/2024, vie
 **/

@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findByIdentificacion(String identificacion);
}
