package com.example.TrinityPrueba.mapper;

import com.example.TrinityPrueba.dtos.ClienteDto;
import com.example.TrinityPrueba.entities.Clientes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {
    public List<ClienteDto> toDto(List<Clientes> clientes) {
        return clientes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ClienteDto toDto(Clientes cliente) {
        ClienteDto dto = new ClienteDto();

        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setMail(cliente.getMail());
        dto.setTipoDeIdentificacion(cliente.getTipoDeIdentificacion());
        dto.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
        dto.setCreacion(cliente.getCreacion());

        return dto;
    }
}
