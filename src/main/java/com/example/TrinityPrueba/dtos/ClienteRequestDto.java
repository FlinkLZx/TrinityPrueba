package com.example.TrinityPrueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {

    private String tipoDeIdentificacion;
    private String numeroIdentificacion;

    private String nombre;
    private String apellido;

    private String mail;

    private LocalDate nacimiento;
}
