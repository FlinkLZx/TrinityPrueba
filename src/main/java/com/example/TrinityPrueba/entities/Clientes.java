package com.example.TrinityPrueba.entities;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Clientes {

    //Correcion pendiente
    @OneToMany
    private List<Productos> tipoDeCuenta;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String tipoDeIdentificacion;
    private String numeroIdentificacion;

    private String nombre;
    private String apellido;

    private String mail;

    private LocalDate nacimiento;

    private LocalDateTime creacion;
    private LocalDateTime modificacion;

    public List<Productos> getTipoDeCuenta() {
        return tipoDeCuenta;
    }
    public void setTipoDeCuenta(List<Productos> tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }
    public void setTipoDeIdentificacion(String tipoDeidentificacion) {
        this.tipoDeIdentificacion = tipoDeidentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getNacimiento() {
        return this.nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
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
