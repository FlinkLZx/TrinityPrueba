package com.example.TrinityPrueba.controllers;

import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.service.ClientesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/find")
    public List<Clientes> getClientes() {
        return clientesService.getClientes();
    }

    @PutMapping("/update")
    public void updateClientes(@RequestBody Clientes clientes) {
        clientesService.updateClientes(clientes);
    }

    @PostMapping("/create")
    public void createClientes(@RequestBody Clientes clientes) throws Exception {
        clientesService.createClientes(clientes);
    }

    @DeleteMapping("/delete")
    public void deleteClientes(Clientes clientes) {
        clientesService.deleteClientes(clientes);
    }
}
