package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

/**
 * @author : Freddy Torres
 * file :  CuentaEntity
 * @since : 1/10/2024, mar
 **/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "cuenta")
public class CuentaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero")
    @NotBlank(message = "{cuenta.numero.missing}")
    @Pattern(regexp = "[0-9]+", message = "{cuenta.numero.format.error}")
    @Size(min = 5, max = 50, message = "{cuenta.numero.size}")
    private String numero;

    @NotNull
    @Column(name = "montoinicial")
    private float montoinicial;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;

    @OneToOne()
    @JoinColumn(name = "tipocuenta")
    private TipoCuentaEntity tipoCuenta;

    @OneToOne()
    @JoinColumn(name = "cliente")
    private ClienteEntity cliente;
}
