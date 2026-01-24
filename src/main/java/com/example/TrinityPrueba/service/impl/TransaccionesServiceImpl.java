package com.example.TrinityPrueba.service.impl;

import com.example.TrinityPrueba.dtos.TransaccionesRequestDto;
import com.example.TrinityPrueba.dtos.TransaccionesResponseDto;
import com.example.TrinityPrueba.entities.Productos;
import com.example.TrinityPrueba.entities.Transacciones;
import com.example.TrinityPrueba.mapper.TransaccionMapper;
import com.example.TrinityPrueba.repository.ProductosRepository;
import com.example.TrinityPrueba.repository.TransaccionesRepository;
import com.example.TrinityPrueba.service.TransaccionesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

    private static final BigDecimal GMF_PORCENTAJE = new BigDecimal("0.004");

    private final ProductosRepository productosRepository;
    private final TransaccionesRepository transaccionesRepository;
    private final TransaccionMapper transaccionMapper;

    public TransaccionesServiceImpl(ProductosRepository productosRepository, TransaccionesRepository transaccionesRepository, TransaccionMapper transaccionMapper) {
        this.productosRepository = productosRepository;
        this.transaccionesRepository = transaccionesRepository;
        this.transaccionMapper = transaccionMapper;
    }

    @Override
    @Transactional
    public TransaccionesResponseDto createTransaccion(TransaccionesRequestDto dto) throws Exception {

        Productos producto = productosRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new Exception("El producto no existe"));

        if (!producto.getEstadoCuenta().equals("Activa")) {
            throw new Exception("La cuenta no esta activa");
        }

        if (dto.getMonto() == null || dto.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("El monto debe ser mayor a cero");
        }

        String tipo = dto.getTipoTransaccion();
        if (!tipo.equals("Consignacion") && !tipo.equals("Retiro")) {
            throw new Exception("Tipo de transaccion no valida");
        }

        BigDecimal saldoActual = producto.getSaldo();
        BigDecimal monto = dto.getMonto();
        BigDecimal gmf = BigDecimal.ZERO;

        if (!producto.getExentaGMF()) {
            gmf = monto.multiply(GMF_PORCENTAJE);
        }

        if (tipo.equals("Retiro")) {

            BigDecimal totalRetiro = monto.add(gmf);

            if (saldoActual.compareTo(totalRetiro) < 0) {
                throw new Exception("Saldo insuficiente");
            }

            producto.setSaldo(saldoActual.subtract(totalRetiro));
        }

        if (tipo.equals("Consignacion")) {
            producto.setSaldo(saldoActual.add(monto));
        }

        productosRepository.save(producto);

        Transacciones transaccion = transaccionMapper.toEntity(dto, producto);

        transaccion.setGMF(gmf);
        transaccion.setFechaTransaccion(LocalDateTime.now());

        Transacciones guardada = transaccionesRepository.save(transaccion);

        return transaccionMapper.toResponse(guardada, producto.getSaldo());
    }

}
