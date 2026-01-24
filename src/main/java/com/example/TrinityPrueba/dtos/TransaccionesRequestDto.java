package com.example.TrinityPrueba.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransaccionesRequestDto {

    private Long productoId;

    private String tipoTransaccion;

    private BigDecimal monto;

}
