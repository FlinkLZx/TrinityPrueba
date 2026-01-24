package com.example.TrinityPrueba.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

   @ManyToOne(optional = false)
   @JoinColumn(nullable = false)
   private Productos producto;

   @Column(nullable = false)
   private String tipoTransaccion;

   @Column(nullable = false)
   private BigDecimal monto;

   @Column(nullable = false)
   private BigDecimal GMF;

   @Column(nullable = false)
    private LocalDateTime fechaTransaccion;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getGMF() {
        return GMF;
    }

    public void setGMF(BigDecimal GMF) {
        this.GMF = GMF;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
