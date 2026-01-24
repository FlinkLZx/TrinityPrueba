package com.example.TrinityPrueba.repository;

import com.example.TrinityPrueba.entities.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {

    List<Transacciones> findByProductoId(Long productoId);

}
