package br.edu.infnet.michellyapi.service;

public class Servico {
    private String nomeServico;
    private String descricaoServico;
    private double valorServico;

    public String getNomeServico() {
        return nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
}
