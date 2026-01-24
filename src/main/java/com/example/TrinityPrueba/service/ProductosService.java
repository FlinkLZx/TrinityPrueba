package com.example.TrinityPrueba.service;

import com.example.TrinityPrueba.entities.Productos;

import java.util.List;

public interface ProductosService {

    List<Productos> getProductos();

    Productos createProductos(Productos productos) throws Exception;

    Productos updateProductos(Long id, Productos productos) throws Exception;

    void deleteProductos(Long id) throws Exception;
}
