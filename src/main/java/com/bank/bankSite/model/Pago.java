package com.bank.bankSite.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "convenio")
@EntityListeners(AuditingEntityListener.class)
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdPago;

    @Column(name = "IdPrestamo", nullable = true)
    private long IdPrestamo;

    @Column(name = "IdServicio", nullable = true)
    private long IdServicio;

    @Column(name = "IdCuenta", nullable = false)
    private long IdCuenta;

    @Column(name = "correlativo", nullable = false)
    private String correlativo;

    @Column(name = "monto", nullable = false)
    private float monto;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    public long getIdPago() {
        return IdPago;
    }

    public void setIdPago(long idPago) {
        IdPago = idPago;
    }

    public long getIdPrestamo() {
        return IdPrestamo;
    }

    public void setIdPrestamo(long idPrestamo) {
        IdPrestamo = idPrestamo;
    }

    public long getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(long idServicio) {
        IdServicio = idServicio;
    }

    public long getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        IdCuenta = idCuenta;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
