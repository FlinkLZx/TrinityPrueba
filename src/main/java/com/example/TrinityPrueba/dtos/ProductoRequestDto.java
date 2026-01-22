package com.example.TrinityPrueba.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductoRequestDto {

    private String tipoDeCuenta;
    private String estadoCuenta;
    private Long clienteId;
    private Boolean exentaGMF;

}
