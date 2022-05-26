package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sugerencia")
@EntityListeners(AuditingEntityListener.class)
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdSugerencia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ip", nullable = false)
    private String ip;

    public long getIdSugerencia() {
        return IdSugerencia;
    }

    public void setIdSugerencia(long idSugerencia) {
        IdSugerencia = idSugerencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
