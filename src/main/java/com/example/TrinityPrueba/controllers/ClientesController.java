package com.example.TrinityPrueba.controllers;

import com.example.TrinityPrueba.dtos.ClienteRequestDto;
import com.example.TrinityPrueba.dtos.ClienteResponseDto;
import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.mapper.ClienteMapper;
import com.example.TrinityPrueba.service.ClientesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;
    private final ClienteMapper clienteMapper;

    public ClientesController(ClientesService clientesService, ClienteMapper clienteMapper) {
        this.clientesService = clientesService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    public List<ClienteResponseDto> getClientes() {
        List<Clientes> clientes = clientesService.getClientes();
        return clienteMapper.toResponseList(clientes);
    }

    @GetMapping("/{id}")
    public ClienteResponseDto getClienteById(@PathVariable Long id) throws Exception {
        Clientes cliente = clientesService.getClientesByID(id);
        return clienteMapper.toResponse(cliente);
    }

    @PutMapping("/{id}")
    public ClienteResponseDto update(@PathVariable long id, @RequestBody ClienteRequestDto dto) throws Exception {
        Clientes cliente = clienteMapper.toEntity(dto);
        Clientes updated = clientesService.updateClientes(id, cliente);

        return clienteMapper.toResponse(updated);
    }

    @PostMapping
    public ClienteResponseDto create(@RequestBody ClienteRequestDto dto) throws Exception {
        Clientes cliente = clienteMapper.toEntity(dto);
        Clientes saved = clientesService.createClientes(cliente);
        return clienteMapper.toResponse(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        clientesService.deleteClientes(id);
    }
}
