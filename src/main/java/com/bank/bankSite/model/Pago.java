package com.bank.bankSite.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
@EntityListeners(AuditingEntityListener.class)
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdPago;

    @Column(name = "correlativo", nullable = false)
    private String correlativo;

    @Column(name = "monto", nullable = false)
    private float monto;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Transient
    public int idPrestamo;

    @ManyToOne
    @JoinColumn(name = "IdPrestamo", nullable = true)
    private Prestamo prestamo;

    @Transient
    public int idServicio;

    @ManyToOne
    @JoinColumn(name = "IdServicio", nullable = true)
    private Servicio servicio;

    @Transient
    public int idTarjeta;

    @ManyToOne
    @JoinColumn(name = "IdTarjeta", nullable = true)
    private Tarjeta tarjeta;

    @Transient
    public int idCuenta;

    @ManyToOne
    @JoinColumn(name = "IdCuenta", nullable = false)
    private Cuenta cuenta;

    public long getIdPago() {
        return IdPago;
    }

    public void setIdPago(long idPago) {
        IdPago = idPago;
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

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
