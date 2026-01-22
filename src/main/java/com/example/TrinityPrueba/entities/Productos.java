package com.example.TrinityPrueba.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String tipoDeCuenta;
    private String estadoCuenta;

    private BigDecimal saldo;
    private Boolean exentaGMF;

    @JoinColumn(name = "cliente_id", nullable = false)
    @ManyToOne
    private Clientes dueño;

    private LocalDateTime creacion;
    private LocalDateTime modificacion;

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }


    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }
    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }


    public String getEstadoCuenta() {
        return estadoCuenta;
    }
    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }


    public Boolean getExentaGMF() {
        return exentaGMF;
    }
    public void setExentaGMF(Boolean exentaGMF) {
        this.exentaGMF = exentaGMF;
    }


    public Clientes getDueño() {
        return dueño;
    }
    public void setDueño(Clientes dueño) {
        this.dueño = dueño;
    }

    public LocalDateTime getCreacion() {
        return creacion;
    }
    public void setCreacion(LocalDateTime creacion) {
        this.creacion = creacion;
    }

    public LocalDateTime getModificacion() {
        return modificacion;
    }
    public void setModificacion(LocalDateTime modificacion) {
        this.modificacion = modificacion;
    }
}
