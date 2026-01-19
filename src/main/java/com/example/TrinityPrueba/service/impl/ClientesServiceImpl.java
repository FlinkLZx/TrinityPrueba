package com.example.TrinityPrueba.service.impl;

import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.repository.ClientesRepository;
import com.example.TrinityPrueba.service.ClientesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository clientesRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public void createClientes(Clientes clientes) throws Exception {
        LocalDate fechaMinima = LocalDate.parse("2007-01-01");
        LocalDate fechaNacimiento = LocalDate.parse(clientes.getNacimiento());

        if(fechaNacimiento.isAfter(fechaMinima)) {
            throw new Exception("Debe ser mayor a 18 años para poder crear una cuenta!");
        }
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaModificacion = LocalDateTime.now();
        clientes.setCreacion(fechaCreacion.toString());
        clientes.setModificacion(fechaModificacion.toString());
        clientes.setNacimiento(fechaNacimiento.toString());
        clientesRepository.save(clientes);
    }

    @Override
    public List<Clientes> getClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public void updateClientes(Clientes clientes) {
        Clientes currentCliente = clientesRepository.findById(clientes.getId()).get();
        currentCliente.setTipoDeIdentificacion(clientes.getTipoDeIdentificacion());
        currentCliente.setNumeroIdentificacion(clientes.getNumeroIdentificacion());
        currentCliente.setNombre(clientes.getNombre());
        currentCliente.setApellido(clientes.getApellido());
        currentCliente.setMail(clientes.getMail());
        currentCliente.setNacimiento(clientes.getNacimiento());
        currentCliente.setModificacion(clientes.getModificacion());
        clientesRepository.save(currentCliente);
    }

    @Override
    public void deleteClientes(Clientes clientes) {
        clientesRepository.deleteById(clientes.getId());
    }
}
