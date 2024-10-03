package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author : Freddy Torres
 * file :  TipoCuentaEntity
 * @since : 1/10/2024, mar
 **/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "tipocuenta")
public class TipoCuentaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
}
