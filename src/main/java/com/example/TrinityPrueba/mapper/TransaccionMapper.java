package com.example.TrinityPrueba.mapper;

import com.example.TrinityPrueba.dtos.TransaccionesRequestDto;
import com.example.TrinityPrueba.dtos.TransaccionesResponseDto;
import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.entities.Transacciones;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransaccionMapper {


    public Transacciones toEntity(TransaccionesRequestDto dto, Productos producto) {

        Transacciones transacciones = new Transacciones();

        producto.setId(dto.getProductoId());

        transacciones.setProducto(producto);
        transacciones.setTipoTransaccion(dto.getTipoTransaccion());
        transacciones.setMonto(dto.getMonto());
        transacciones.setProducto(producto);

        return transacciones;
    }

    public TransaccionesResponseDto toResponse(
            Transacciones transaccion, java.math.BigDecimal saldoFinal
    ) {
        TransaccionesResponseDto dto = new TransaccionesResponseDto();

        dto.setId(transaccion.getId());
        dto.setProductoId(transaccion.getProducto().getId());
        dto.setTipoTransaccion(transaccion.getTipoTransaccion());
        dto.setMonto(transaccion.getMonto());
        dto.setGMF(transaccion.getGMF());
        dto.setSaldoFinal(saldoFinal);
        dto.setFechaTransaccion(transaccion.getFechaTransaccion());

        return dto;
    }
}
