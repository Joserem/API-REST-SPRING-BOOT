package com.jose.apiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "navios")
public class Navio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_navio_classe", nullable = false)
    private String nomeNavioClasse;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeNavioClasse() {
        return nomeNavioClasse;
    }

    public void setNomeNavioClasse(String nomeNavioClasse) {
        this.nomeNavioClasse = nomeNavioClasse;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
