package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "convenio")
@EntityListeners(AuditingEntityListener.class)
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdConvenio;

    @Column(name = "IdCliente", nullable = false)
    private long idCliente;

    public long getIdConvenio() {
        return IdConvenio;
    }

    public void setIdConvenio(long idConvenio) {
        IdConvenio = idConvenio;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}
