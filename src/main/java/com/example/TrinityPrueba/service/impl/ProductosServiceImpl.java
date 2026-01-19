package com.example.TrinityPrueba.service.impl;

import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.repository.ClientesRepository;
import com.example.TrinityPrueba.repository.ProductosRepository;
import com.example.TrinityPrueba.service.ProductosService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void createProductos (Productos productos) throws Exception {
        if (!clientesRepository.existsById(productos.getDueño().getId())) {
            throw new Exception("El id del clientes no existe");
        }
        productos.setDueño(clientesRepository.findById(productos.getDueño().getId()).get());
        productos.setExentaGMF(Boolean.FALSE);

        if (!productos.getTipoDeCuenta().equals("Ahorros") || !productos.getTipoDeCuenta().equals("Corriente")) {
            throw new Exception("El tipo de cuenta no es valido!");
        }
        productosRepository.save(productos);

        if (!productos.getEstadoCuenta().equals("Activo") || !productos.getEstadoCuenta().equals("Inactivo") || !productos.getTipoDeCuenta().equals("Cancelada")) {
            throw new Exception("El estado de cuenta no es valido!");
        }
        productosRepository.save(productos);

        //hacer logica de cuenta exenta y hacer el mapeo de cuentas ya existentes con ese exento
        if (productos.getExentaGMF().equals(Boolean.FALSE)) {

        } else if (productos.getExentaGMF().equals(Boolean.TRUE)) {

        }
    }

    @Override
    public void updateProductos (Productos productos) throws Exception {
        Productos currentProductos = productosRepository.findById(productos.getId()).get();
        if (!currentProductos.getEstadoCuenta().equals("Activo") || !currentProductos.getEstadoCuenta().equals("Inactivo") ) {
            throw new Exception("El estado de cuenta no es valido!");
        }
        currentProductos.setEstadoCuenta(productos.getEstadoCuenta());
        productosRepository.save(productos);

        //Terminar la logica de aca
        Productos currentProductosExenta = productosRepository.findById(productos.getId())
                .orElseThrow(() -> new Exception("El id del cliente no existe!"));
        if (currentProductosExenta.getExentaGMF().equals(Boolean.TRUE)) {
            throw new Exception("La cuenta ya se encuentra exenta!");
        }
        currentProductosExenta.setExentaGMF(productos.getExentaGMF());
    }

    @Override
    public void deleteProductos(Productos productos) throws Exception {
        if (!productos.getSaldo().equals("0")) {
            throw new Exception("No se puede eliminar una cuenta con saldo disponible!");
        }
        productosRepository.deleteById(productos.getId());
    }
}
