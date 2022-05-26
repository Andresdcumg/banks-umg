package com.bank.bankSite.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Banco")
@EntityListeners(AuditingEntityListener.class)
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdBanco;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + IdBanco +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public long getIdBanco() {
        return IdBanco;
    }

    public void setIdBanco(long idBanco) {
        IdBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
