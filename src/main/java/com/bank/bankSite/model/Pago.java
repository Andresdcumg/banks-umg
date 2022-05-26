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

    @Column(name = "IdConvenio", nullable = false)
    private long idConvenio;

    @Column(name = "solicitud", nullable = false)
    private long solicitud;

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

    public long getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(long idConvenio) {
        this.idConvenio = idConvenio;
    }

    public long getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(long solicitud) {
        this.solicitud = solicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
