package com.example.TrinityPrueba.service;

import com.example.TrinityPrueba.entities.Clientes;

import java.util.List;

public interface ClientesService {

    List<Clientes> getClientes();

    void createClientes(Clientes clientes) throws Exception;

    void updateClientes(Clientes clientes);

    void deleteClientes(Clientes clientes);
}
