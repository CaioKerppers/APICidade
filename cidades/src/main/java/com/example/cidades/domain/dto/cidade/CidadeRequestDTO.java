package com.example.cidades.domain.dto.cidade;

public class CidadeRequestDTO {
    private String nome;
    private String pais;
    private String estado;
    private Long populacao;
    private String lingua;
    private Integer anoDeCriacao;

    // Getters e Setters
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
