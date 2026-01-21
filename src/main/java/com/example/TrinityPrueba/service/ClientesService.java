package com.example.TrinityPrueba.service;

import com.example.TrinityPrueba.entities.Clientes;

import java.util.List;

public interface ClientesService {

    List<Clientes> getClientes();

    Clientes createClientes(Clientes clientes) throws Exception;

    Clientes getClientesByID(Long id) throws Exception;

    Clientes updateClientes(Long id, Clientes clientes) throws Exception;

    void deleteClientes(Long id) throws Exception;
}
