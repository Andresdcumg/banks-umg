package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamo")
@EntityListeners(AuditingEntityListener.class)
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdPrestamo;
    @Column(name = "monto", nullable = false)
    private float monto;

    @Column(name = "saldo", nullable = false)
    private float saldo;

    @Column(name = "pago", nullable = false)
    private Date pago;

    @Transient
    public int idCliente;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    public long getIdPrestamo() {
        return IdPrestamo;
    }

    public void setIdPrestamo(long idPrestamo) {
        IdPrestamo = idPrestamo;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getPago() {
        return pago;
    }

    public void setPago(Date pago) {
        this.pago = pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
