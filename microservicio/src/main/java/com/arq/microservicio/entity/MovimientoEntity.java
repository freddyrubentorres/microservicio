package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

/**
 * @author : Freddy Torres
 * file :  MovimientoEntity
 * @since : 2/10/2024, mié
 **/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "movimiento")
public class MovimientoEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fecha")
    private Date fecha;
    @NotNull
    @Column(name = "monto")
    private Float monto;
    @NotNull
    @Column(name = "saldodisponible")
    private Float saldodisponible;
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechahora")
    private Date fechahora;
    @OneToOne()
    @JoinColumn(name = "tipomovimiento")
    private TipoMovimientoEntity tipomovimiento;
    @OneToOne()
    @JoinColumn(name = "cuenta")
    private CuentaEntity cuenta;
}
