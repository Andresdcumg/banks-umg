package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "ahorro")
@EntityListeners(AuditingEntityListener.class)
public class Ahorro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdAhorro;

    @Column(name = "IdCliente", nullable = false)
    private long idCliente;

    @Column(name = "Saldo", nullable = false)
    private float saldo;

    public long getIdMon() {
        return IdAhorro;
    }

    public void setIdMon(long idMon) {
        IdAhorro = idMon;
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
