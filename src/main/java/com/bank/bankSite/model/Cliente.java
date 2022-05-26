package com.bank.bankSite.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdCliente;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellidos", nullable = true)
    private String apellido;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "IdBanco", nullable = false)
    private long idBanco;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + IdCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * @return int
     */
    public long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(long idCliente) {
        this.IdCliente = idCliente;
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

    public void setApellido(String apellidos) {
        this.apellido = apellidos;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(long idBanco) {
        this.idBanco = idBanco;
    }
}
