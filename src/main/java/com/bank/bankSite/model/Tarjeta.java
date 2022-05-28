package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tarjeta")
@EntityListeners(AuditingEntityListener.class)
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdTarjeta;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "titular", nullable = false)
    private String titular;

    @Column(name = "cvv", nullable = false)
    private long cvv;

    @Column(name = "vencimiento", nullable = true)
    private Date vencimiento;

    @Column(name = "montoAutorizado", nullable = false)
    private float montoAutorizado;

    @Column(name = "montoUsado", nullable = false)
    private float montoUsado;

    @Column(name = "corte", nullable = false)
    private Date corte;

    @Column(name = "pago", nullable = false)
    private Date pago;

    @Transient
    public int idCliente;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    public long getIdTarjeta() {
        return IdTarjeta;
    }

    public void setIdTarjeta(long idTarjeta) {
        IdTarjeta = idTarjeta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getMontoAutorizado() {
        return montoAutorizado;
    }

    public void setMontoAutorizado(float montoAutorizado) {
        this.montoAutorizado = montoAutorizado;
    }

    public float getMontoUsado() {
        return montoUsado;
    }

    public void setMontoUsado(float montoUsado) {
        this.montoUsado = montoUsado;
    }

    public Date getCorte() {
        return corte;
    }

    public void setCorte(Date corte) {
        this.corte = corte;
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
