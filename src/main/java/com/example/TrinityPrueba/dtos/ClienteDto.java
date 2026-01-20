package com.example.TrinityPrueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long Id;

    private String tipoDeIdentificacion;

    private String numeroIdentificacion;

    private String nombre;

    private String apellido;

    private String mail;

    private String nacimiento;

    private String creacion;

}
