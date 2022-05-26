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

    @Column(name = "IdCliente", nullable = false)
    private long idCliente;

    @Column(name = "tipo", nullable = false)
    private String tipo = TIPO_MONETARIA;

    @Column(name = "Saldo", nullable = false)
    private float saldo;

    public long getIdMon() {
        return IdMon;
    }

    public void setIdMon(long idMon) {
        IdMon = idMon;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
