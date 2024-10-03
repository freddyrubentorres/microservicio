package com.arq.microservicio.repository;

import com.arq.microservicio.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Freddy Torres
 * file :  IUsuarioEntity
 * @since : 26/9/2024, jue
 **/

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
