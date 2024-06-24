package com.example.cidades.domain.dto.dashboard;

import java.util.List;

import com.example.cidades.domain.dto.cidade.CidadeResponseDTO;

public class DashboardResponseDTO {
    private String pais;
    private String estado;
    private long populacaoTotal;
    private String lingua;
    private int anoDeCriacao;
    private List<CidadeResponseDTO> cidades;

    // Construtor vazio
    public DashboardResponseDTO() {}

    // Construtor completo
    public DashboardResponseDTO(String pais, String estado, long populacaoTotal, String lingua, int anoDeCriacao, List<CidadeResponseDTO> cidades) {
        this.pais = pais;
        this.estado = estado;
        this.populacaoTotal = populacaoTotal;
        this.lingua = lingua;
        this.anoDeCriacao = anoDeCriacao;
        this.cidades = cidades;
    }

    // Construtor que aceita uma lista de CidadeResponseDTO
    public DashboardResponseDTO(List<CidadeResponseDTO> cidades) {
        this.cidades = cidades;
        this.pais = cidades.stream().map(CidadeResponseDTO::getPais).distinct().findFirst().orElse(null);
        this.estado = cidades.stream().map(CidadeResponseDTO::getEstado).distinct().findFirst().orElse(null);
        this.populacaoTotal = cidades.stream().mapToLong(CidadeResponseDTO::getPopulacao).sum();
        this.lingua = cidades.stream().map(CidadeResponseDTO::getLingua).distinct().findFirst().orElse(null);
        this.anoDeCriacao = cidades.stream().mapToInt(CidadeResponseDTO::getAnoDeCriacao).min().orElse(0);
    }

    // Getters e Setters
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

    public long getPopulacaoTotal() {
        return populacaoTotal;
    }

    public void setPopulacaoTotal(long populacaoTotal) {
        this.populacaoTotal = populacaoTotal;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public List<CidadeResponseDTO> getCidades() {
        return cidades;
    }

    public void setCidades(List<CidadeResponseDTO> cidades) {
        this.cidades = cidades;
    }
}
