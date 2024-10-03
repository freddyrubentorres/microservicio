package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

/**
 * @author : Freddy Torres
 * file :  ClienteEntity
 * @since : 27/9/2024, vie
 **/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @NotNull
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "genero")
    private String genero;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioid")
    private UsuarioEntity usuario;
}
