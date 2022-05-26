package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "cheque")
@EntityListeners(AuditingEntityListener.class)
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdCheque;

    @Column(name = "IdCliente", nullable = false)
    private long idCliente;

    @Column(name = "cantidadcheque", nullable = false)
    private float cantidadCheque;

    public long getIdCheque() {
        return IdCheque;
    }

    public void setIdCheque(long idCheque) {
        IdCheque = idCheque;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public float getCantidadCheque() {
        return cantidadCheque;
    }

    public void setCantidadCheque(float cantidadCheque) {
        this.cantidadCheque = cantidadCheque;
    }
}
