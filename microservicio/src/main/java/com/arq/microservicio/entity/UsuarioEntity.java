package com.arq.microservicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

/**
 * @author : Freddy Torres
 * file :  UsuarioEntity
 * @since : 26/9/2024, jue
 **/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    @NotBlank(message = "Email es obligatorio")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Formato de email incorrecto")
    @Size(min = 10, max = 50, message = "Email debe tener entre 10 y 50 caracteres.")
    private String email;

    @NotNull
    @Column(name = "password")
    @NotBlank(message = "Password es obligatorio")
    @Size(min = 10, max = 255, message = "Password debe tener entre 10 y 50 caracteres.")
    private String password;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;

}