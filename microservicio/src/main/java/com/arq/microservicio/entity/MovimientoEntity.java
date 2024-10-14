package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Column(name = "descripcion")
    @NotBlank(message = "{movimiento.descripcion.missing}")
    @Size(min = 10, max = 255, message = "{movimiento.descripcion.size}")
    private String descripcion;

    @Column(name = "fecha")
    private Date fecha;

    @NotNull(message = "{movimiento.monto.missing}")
    @Column(name = "monto")
    private Float monto;

    @Column(name = "saldodisponible")
    private Float saldodisponible;

    @Column(name = "fechahora")
    private Date fechahora;

    @OneToOne()
    @JoinColumn(name = "tipomovimiento")
    private TipoMovimientoEntity tipomovimiento;

    @OneToOne()
    @JoinColumn(name = "cuenta")
    private CuentaEntity cuenta;
}
