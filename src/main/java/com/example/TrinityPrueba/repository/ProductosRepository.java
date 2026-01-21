package com.example.TrinityPrueba.repository;

import com.example.TrinityPrueba.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {

    boolean existsByDueñoId(Long dueñoId);

}
