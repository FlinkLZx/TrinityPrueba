package com.example.TrinityPrueba.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductoResponseDto {

    private Long id;

    private String tipoDeCuenta;
    private String estadoCuenta;

    private BigDecimal saldo;
    private Boolean exentaGMF;

    private Long clienteId;

    private LocalDateTime creacion;


}
