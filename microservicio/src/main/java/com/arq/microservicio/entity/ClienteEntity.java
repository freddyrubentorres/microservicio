package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Column(name = "nombre")
    @NotBlank(message = "{cliente.nombre.missing}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{cliente.nombre.format.error}")
    @Size(min = 3, max = 50, message = "{cliente.nombre.size}")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "{cliente.apellido.missing}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{cliente.apellido.format.error}")
    @Size(min = 3, max = 50, message = "{cliente.apellido.size}")
    private String apellido;

    @Column(name = "direccion")
    @NotBlank(message = "{cliente.direccion.missing}")
    @Size(min = 5, max = 255, message = "{cliente.direccion.size}")
    private String direccion;

    @Column(name = "telefono")
    @NotBlank(message = "{cliente.telefono.missing}")
    @Pattern(regexp = "[0-9]+", message = "{cliente.telefono.format.error}")
    @Size(min = 7, max = 50, message = "{cliente.telefono.size}")
    private String telefono;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "genero")
    @NotBlank(message = "{cliente.genero.missing}")
    @Pattern(regexp = "^([MF])$", message = "{cliente.genero.input}")
    private String genero;

    @Column(name = "identificacion")
    @NotBlank(message = "{cliente.identificacion.missing}")
    @Pattern(regexp = "[0-9]+", message = "{cliente.identificacion.format.error}")
    @Size(min = 5, max = 10, message = "{cliente.identificacion.size}")
    private String identificacion;

    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioid")
    private UsuarioEntity usuario;
}
