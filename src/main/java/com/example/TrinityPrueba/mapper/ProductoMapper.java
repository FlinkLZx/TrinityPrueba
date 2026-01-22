package com.example.TrinityPrueba.mapper;

import com.example.TrinityPrueba.dtos.ProductoRequestDto;
import com.example.TrinityPrueba.dtos.ProductoResponseDto;
import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.entities.Productos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {

    public Productos toEntity(ProductoRequestDto dto) {
        Productos producto = new Productos();

        if (dto.getClienteId() != null) {
            Clientes cliente = new Clientes();
            cliente.setId(dto.getClienteId());

            producto.setDueño(cliente);
        }

        producto.setExentaGMF(dto.getExentaGMF());
        producto.setEstadoCuenta(dto.getEstadoCuenta());
        producto.setTipoDeCuenta(dto.getTipoDeCuenta());

        return producto;
    }

    public ProductoResponseDto toResponse(Productos producto) {
        ProductoResponseDto dto = new ProductoResponseDto();

        dto.setId(producto.getId());
        dto.setTipoDeCuenta(producto.getTipoDeCuenta());
        dto.setEstadoCuenta(producto.getEstadoCuenta());
        dto.setExentaGMF(producto.getExentaGMF());
        dto.setSaldo(producto.getSaldo());
        dto.setClienteId(producto.getDueño().getId());
        dto.setCreacion(producto.getCreacion());

        return dto;

    }

    public List<ProductoResponseDto> toResponse(List<Productos> productos) {
        return productos.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
