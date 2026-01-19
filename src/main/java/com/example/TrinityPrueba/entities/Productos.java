package com.example.TrinityPrueba.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String tipoDeCuenta;

    private String estadoCuenta;

    private String saldo;

    private Boolean exentaGMF;

    @ManyToOne
    private Clientes dueño;

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

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
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
}
