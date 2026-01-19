package com.example.TrinityPrueba.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String tipoDeTransaccion;

    private Float dinero;

    @ManyToOne
    private Productos destinatario;

    @ManyToOne
    private Productos emisor;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTipoDeTransaccion() {
        return tipoDeTransaccion;
    }

    public void setTipoDeTransaccion(String tipoDeTransaccion) {
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public Float getDinero() {
        return dinero;
    }

    public void setDinero(Float dinero) {
        this.dinero = dinero;
    }

    public Productos getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Productos destinatario) {
        this.destinatario = destinatario;
    }

    public Productos getEmisor() {
        return emisor;
    }

    public void setEmisor(Productos emisor) {
        this.emisor = emisor;
    }
}
