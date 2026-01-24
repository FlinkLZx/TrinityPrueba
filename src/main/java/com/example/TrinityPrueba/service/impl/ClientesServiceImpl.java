package com.example.TrinityPrueba.service.impl;

import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.repository.ClientesRepository;
import com.example.TrinityPrueba.repository.ProductosRepository;
import com.example.TrinityPrueba.service.ClientesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository clientesRepository;
    private final ProductosRepository productosRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository, ProductosRepository productosRepository) {
        this.clientesRepository = clientesRepository;
        this.productosRepository = productosRepository;
    }

    @Override
    public Clientes createClientes(Clientes clientes) throws Exception {

        int edad = Period.between(clientes.getNacimiento(), LocalDate.now()).getYears();
        if (edad < 18) {
            throw new Exception("El cliente debe ser mayor de edad");
        }

        if (clientes.getNombre().length() < 2 || clientes.getApellido().length() < 2 ) {
            throw new Exception("Nombre y apellido invalidos");
        }

        clientes.setCreacion(LocalDateTime.now());
        clientes.setModificacion(null);

        return clientesRepository.save(clientes);
    }


    @Override
    public List<Clientes> getClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes getClientesByID(Long id) throws Exception {
        return clientesRepository.findById(id).orElseThrow(() -> new Exception("Cliente no encontrado"));
    }


    @Override
    public Clientes updateClientes(Long id, Clientes clientes) throws Exception {

        Clientes current = clientesRepository.findById(id)
                .orElseThrow(() -> new Exception("El cliente no existe"));

        current.setNombre(clientes.getNombre());
        current.setApellido(clientes.getApellido());
        current.setMail(clientes.getMail());

        current.setModificacion(LocalDateTime.now());

        return clientesRepository.save(current);
    }


    @Override
    public void deleteClientes(Long id) throws Exception {

        Clientes cliente = clientesRepository.findById(id).orElseThrow(() -> new Exception("El cliente no existe"));

        boolean tieneProductos = productosRepository.existsByClienteId(cliente.getId());
        if (tieneProductos) {
            throw new Exception("No se puede eliminar un cliente con productos asociados");
        }
    }
}
