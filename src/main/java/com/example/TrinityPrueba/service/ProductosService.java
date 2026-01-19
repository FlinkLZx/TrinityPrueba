package com.example.TrinityPrueba.service;

import com.example.TrinityPrueba.entities.Productos;

import java.util.List;

public interface ProductosService {

    List<Productos> getProductos();

    void createProductos(Productos productos) throws Exception;

    void updateProductos(Productos productos) throws Exception;

    void deleteProductos(Productos productos) throws Exception;
}
