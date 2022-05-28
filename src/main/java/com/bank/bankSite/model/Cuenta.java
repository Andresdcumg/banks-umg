package com.bank.bankSite.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cuenta")
@EntityListeners(AuditingEntityListener.class)
public class Cuenta {
    public static final String TIPO_MONETARIA = "monetaria";
    public static final String TIPO_AHORRO = "ahorro";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdMon;

    @Column(name = "tipo", nullable = false)
    private String tipo = TIPO_MONETARIA;

    @Column(name = "Saldo", nullable = false)
    private float saldo;

    @Transient
    public int idCliente;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    public long getIdMon() {
        return IdMon;
    }

    public void setIdMon(long idMon) {
        IdMon = idMon;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
