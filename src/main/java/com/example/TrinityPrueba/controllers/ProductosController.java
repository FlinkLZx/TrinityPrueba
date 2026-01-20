package com.example.TrinityPrueba.controllers;

import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.service.ClientesService;
import com.example.TrinityPrueba.service.ProductosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;
    private final ClientesService clientesService;

    public ProductosController(ProductosService productosService, ClientesService clientesService) {
        this.productosService = productosService;
        this.clientesService = clientesService;
    }

    @GetMapping("/get")
    public List<Productos> getProductos() {
        return productosService.getProductos();
    }

    @GetMapping("/update")
    public void updateProductos(@RequestBody Productos productos) throws Exception {
        productosService.updateProductos(productos);
    }

    @GetMapping("/create")
    public void createProductos(Productos productos) throws Exception {
        productosService.createProductos(productos);
    }

    @GetMapping("/delete")
    public void deleteProductos(Productos productos) throws Exception {
        productosService.deleteProductos(productos);
    }
}
