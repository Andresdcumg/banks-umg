package com.bank.bankSite.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transferencia")
@EntityListeners(AuditingEntityListener.class)
public class Transferencia {
    public static final String TIPO_PROPIA = "propia";
    public static final String TIPO_TERCEROS = "terceros";
    public static final String TIPO_ACH = "ach";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdTransferencia;

    @Column(name = "cuentaDebito", nullable = false)
    private long cuentaDebito;

    @Column(name = "cuentaCredito", nullable = false)
    private long cuentaCredito;

    @Column(name = "tipo", nullable = false)
    private String tipo = TIPO_PROPIA;

    @Column(name = "IdBanco", nullable = false)
    private long IdBanco;

    @Column(name = "monto", nullable = false)
    private float monto;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creadoEl", nullable = false)
    private Date creadoEl;

    @Column(name = "aceptadaEl", nullable = true)
    private Date aceptadaEl;

    @Column(name = "rechazadaEl", nullable = true)
    private Date rechazadaEl;

    public long getIdTransferencia() {
        return IdTransferencia;
    }

    public void setIdTransferencia(long idTransferencia) {
        IdTransferencia = idTransferencia;
    }

    public long getCuentaDebito() {
        return cuentaDebito;
    }

    public void setCuentaDebito(long cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public long getCuentaCredito() {
        return cuentaCredito;
    }

    public void setCuentaCredito(long cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getIdBanco() {
        return IdBanco;
    }

    public void setIdBanco(long idBanco) {
        IdBanco = idBanco;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

    public Date getAceptadaEl() {
        return aceptadaEl;
    }

    public void setAceptadaEl(Date aceptadaEl) {
        this.aceptadaEl = aceptadaEl;
    }

    public Date getRechazadaEl() {
        return rechazadaEl;
    }

    public void setRechazadaEl(Date rechazadaEl) {
        this.rechazadaEl = rechazadaEl;
    }
}
