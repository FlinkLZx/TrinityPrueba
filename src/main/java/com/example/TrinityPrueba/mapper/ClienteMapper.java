package com.example.TrinityPrueba.mapper;

import com.example.TrinityPrueba.dtos.ClienteRequestDto;
import com.example.TrinityPrueba.dtos.ClienteResponseDto;
import com.example.TrinityPrueba.entities.Clientes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Clientes toEntity(ClienteRequestDto dto) {
        Clientes cliente = new Clientes();
        cliente.setTipoDeIdentificacion(dto.getTipoDeIdentificacion());
        cliente.setNumeroIdentificacion(dto.getNumeroIdentificacion());
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setMail(dto.getMail());
        cliente.setNacimiento(dto.getNacimiento());

        return cliente;
    }

    public ClienteResponseDto toResponse(Clientes cliente) {
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getId());
        dto.setTipoDeIdentificacion(cliente.getTipoDeIdentificacion());
        dto.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setMail(cliente.getMail());
        dto.setNacimiento(cliente.getNacimiento());
        dto.setCreacion(cliente.getCreacion());
        dto.setModificacion(cliente.getModificacion());

        return dto;
    }

    public List<ClienteResponseDto> toResponseList(List<Clientes> clientes) {
        return clientes.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
