package com.example.TrinityPrueba.controllers;

import com.example.TrinityPrueba.dtos.ProductoRequestDto;
import com.example.TrinityPrueba.dtos.ProductoResponseDto;
import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.mapper.ProductoMapper;
import com.example.TrinityPrueba.service.ProductosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;
    private final ProductoMapper productoMapper;

    public ProductosController(ProductosService productosService, ProductoMapper productoMapper) {
        this.productosService = productosService;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<ProductoResponseDto> getProductos() {
        return productoMapper.toResponse(
                productosService.getProductos()
        );
    }

    @PutMapping("/{id}")
    public ProductoResponseDto updateProductos(@PathVariable Long id, @RequestBody ProductoRequestDto dto) throws Exception {
        Productos producto = productoMapper.toEntity(dto);
        Productos update = productosService.updateProductos(id, producto);

        return productoMapper.toResponse(update);
    }

    @PostMapping
    public ProductoResponseDto createProductos(@RequestBody ProductoRequestDto dto) throws Exception {
        Productos producto = productoMapper.toEntity(dto);
        Productos saved = productosService.createProductos(producto);

        return productoMapper.toResponse(saved);
    }

    @DeleteMapping("/{id}")
    public void deleteProductos(@PathVariable Long id) throws Exception {
        productosService.deleteProductos(id);
    }
}
