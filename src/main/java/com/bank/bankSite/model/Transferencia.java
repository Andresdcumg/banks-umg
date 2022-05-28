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

    @Transient
    public int idCuentaDebito;

    @ManyToOne
    @JoinColumn(name = "cuentaDebito", nullable = false)
    private Cuenta cuentaDebito;

    @Transient
    public int idCuentaCredito;

    @ManyToOne
    @JoinColumn(name = "cuentaCredito", nullable = false)
    private Cuenta cuentaCredito;

    @Column(name = "tipo", nullable = false)
    private String tipo = TIPO_PROPIA;

    @Transient
    public int idBanco;

    @ManyToOne
    @JoinColumn(name = "IdBanco")
    private Banco banco;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
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

    public int getIdCuentaDebito() {
        return idCuentaDebito;
    }

    public void setIdCuentaDebito(int idCuentaDebito) {
        this.idCuentaDebito = idCuentaDebito;
    }

    public Cuenta getCuentaDebito() {
        return cuentaDebito;
    }

    public void setCuentaDebito(Cuenta cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public int getIdCuentaCredito() {
        return idCuentaCredito;
    }

    public void setIdCuentaCredito(int idCuentaCredito) {
        this.idCuentaCredito = idCuentaCredito;
    }

    public Cuenta getCuentaCredito() {
        return cuentaCredito;
    }

    public void setCuentaCredito(Cuenta cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
