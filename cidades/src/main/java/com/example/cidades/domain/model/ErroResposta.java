package com.example.cidades.domain.model;

public class ErroResposta {
    private String dataHora;
    private Integer status;
    private String cidade;
    private String mensagem;

    public ErroResposta(String dataHora, Integer status, String cidade, String mensagem) {
        this.dataHora = dataHora;
        this.status = status;
        this.cidade = cidade;
        this.mensagem = mensagem;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
