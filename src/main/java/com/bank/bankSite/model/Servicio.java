package com.bank.bankSite.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "servicio")
@EntityListeners(AuditingEntityListener.class)
public class Servicio {
    public static final String TIPO_TELEFONO = "telefono";
    public static final String TIPO_ELECTRICIDAD = "electricidad";
    public static final String TIPO_AGUA = "agua";

    public static final String VERIFICADOR_CLARO = "claro"; // Solo si el tipo es TIPO_TELEFONO
    public static final String VERIFICADOR_EGGSA = "eggsa"; // Solo si el tipo es TIPO_ELECTRICIDAD
    public static final String VERIFICADOR_EMPAGUA = "empagua"; // Solo si el tipo es TIPO_AGUA

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdServicio;

    @Column(name = "tipo", nullable = false)
    private String tipo = TIPO_TELEFONO;

    @Column(name = "verificador", nullable = false)
    private String verificador = VERIFICADOR_CLARO;

    public long getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(long idServicio) {
        IdServicio = idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }
}
