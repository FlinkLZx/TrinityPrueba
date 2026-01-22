package com.example.TrinityPrueba.service.impl;

import com.example.TrinityPrueba.entities.Clientes;
import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.repository.ClientesRepository;
import com.example.TrinityPrueba.repository.ProductosRepository;
import com.example.TrinityPrueba.service.ProductosService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;
    private final ClientesRepository clientesRepository;

    public ProductosServiceImpl(ProductosRepository productosRepository, ClientesRepository clientesRepository) {
        this.productosRepository= productosRepository;
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Productos> getProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos createProductos (Productos productos) throws Exception {
        Long clienteId = productos.getDueño().getId();
        Clientes cliente = clientesRepository.findById(clienteId).orElseThrow(() -> new Exception("El cliente no existe"));

        if (!productos.getTipoDeCuenta().equals("Ahorros") && !productos.getTipoDeCuenta().equals("Corriente")) {
            throw new Exception("El tipo de cuenta no es valido!");
        }

        productos.setDueño(cliente);
        productos.setEstadoCuenta("Activa");
        productos.setSaldo(BigDecimal.ZERO);
        productos.setExentaGMF(false);
        productos.setCreacion(LocalDateTime.now());

        return productosRepository.save(productos);
    }

    @Override
    public Productos updateProductos (Long id, Productos productos) throws Exception {

        Productos actual= productosRepository.findById(id).orElseThrow(() -> new Exception("El producto no existe"));

        if (productos.getEstadoCuenta() != null) {
            if (!productos.getEstadoCuenta().equals("Activa") &&
                !productos.getEstadoCuenta().equals("Inactiva") &&
                !productos.getEstadoCuenta().equals("Cancelada")) {
                throw new Exception("Estado de cuenta no valido");
            }

            actual.setEstadoCuenta(productos.getEstadoCuenta());
        }

        if (productos.getExentaGMF() != null && productos.getExentaGMF()) {

            if (actual.getExentaGMF()) {
                throw new Exception("La cuenta ya es exenta GMF");
            }

            boolean clienteYaTieneExenta = productosRepository.existsByDueñoIdAndExentaGMFTrue(
                    actual.getDueño().getId()
            );

            if (clienteYaTieneExenta) {
                throw new Exception("El cliente ya tiene una cuenta exenta GMF");
            }

            actual.setExentaGMF(true);
        }

        actual.setModificacion(LocalDateTime.now());

        return productosRepository.save(actual);
    }

    @Override
    public void deleteProductos(Long id) throws Exception {

        Productos producto = productosRepository.findById(id)
                .orElseThrow(() -> new Exception("El producto no existe"));

        if (producto.getSaldo().compareTo(BigDecimal.ZERO) != 0) {
            throw new Exception("No se puede eliminar una cuenta con saldo");
        }

        if (!producto.getEstadoCuenta().equals("Cancelada")) {
            throw new Exception("La cuenta debe ser Cancelada para eliminarse");
        }

        productosRepository.deleteById(id);
    }
}
