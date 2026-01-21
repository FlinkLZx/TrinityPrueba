package com.example.TrinityPrueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDto {

    private Long id;

    private String tipoDeIdentificacion;
    private String numeroIdentificacion;

    private String nombre;
    private String apellido;

    private String mail;

    private LocalDate nacimiento;

    private LocalDateTime creacion;
    private LocalDateTime modificacion;
}
