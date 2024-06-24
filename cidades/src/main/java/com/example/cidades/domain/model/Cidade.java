package com.example.cidades.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCidade")
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String pais;
    
    @Column(nullable = false)
    private String estado;
    
    @Column(nullable = false)
    private Long populacao;
    
    @Column(nullable = false)
    private String lingua;
    
    @Column(nullable = false)
    private Integer anoDeCriacao;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getPopulacao() {
        return populacao;
    }
    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }
    public String getLingua() {
        return lingua;
    }
    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }
}
