package com.example.TrinityPrueba.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransaccionesResponseDto {

    private Long id;

    private Long productoId;

    private String tipoTransaccion;

    private BigDecimal monto;

    private BigDecimal GMF;

    private BigDecimal saldoFinal;

    private LocalDateTime fechaTransaccion;

}
