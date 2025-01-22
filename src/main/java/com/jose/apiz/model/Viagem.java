package com.jose.apiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "viagens")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_navio", nullable = false)
    private Integer idNavio;

    @Column(name = "status_viagem", nullable = false)
    private String statusViagem;

    @Column(name = "id_berco", nullable = false)
    private Integer idBerco;

    @Column(name = "tipo_carga", nullable = false)
    private String tipoCarga;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdNavio() {
        return idNavio;
    }

    public void setIdNavio(Integer idNavio) {
        this.idNavio = idNavio;
    }

    public String getStatusViagem() {
        return statusViagem;
    }

    public void setStatusViagem(String statusViagem) {
        this.statusViagem = statusViagem;
    }

    public Integer getIdBerco() {
        return idBerco;
    }

    public void setIdBerco(Integer idBerco) {
        this.idBerco = idBerco;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    
}
