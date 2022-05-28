package com.bank.bankSite.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cheque")
@EntityListeners(AuditingEntityListener.class)
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdCheque;

    @Column(name = "receptor", nullable = false)
    private String receptor;

    @Column(name = "monto", nullable = false)
    private float monto;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creadoEl", nullable = false)
    private Date creadoEl;

    @Column(name = "cobradoEl", nullable = true)
    private Date cobradoEl;

    @Column(name = "rechazadoEl", nullable = true)
    private Date rechazadoEl;

    @Transient
    public int idCuenta;

    @ManyToOne
    @JoinColumn(name = "IdCuenta")
    private Cuenta cuenta;

    public long getIdCheque() {
        return IdCheque;
    }

    public void setIdCheque(long idCheque) {
        IdCheque = idCheque;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
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

    public Date getCobradoEl() {
        return cobradoEl;
    }

    public void setCobradoEl(Date cobradoEl) {
        this.cobradoEl = cobradoEl;
    }

    public Date getRechazadoEl() {
        return rechazadoEl;
    }

    public void setRechazadoEl(Date rechazadoEl) {
        this.rechazadoEl = rechazadoEl;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
