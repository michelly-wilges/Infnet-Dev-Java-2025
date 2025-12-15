package br.edu.infnet.michellyapi.entidades;

import br.edu.infnet.michellyapi.enums.TipoServico;

public class Servico {
    private String nomeServico;
    private String descricaoServico;
    private double valorServico;
    private TipoServico tipo;
    private int duracaoMinutos;

    public Servico() {}

    public Servico(String nomeServico, double valorServico, TipoServico tipo) {
        this.nomeServico = nomeServico;
        this.valorServico = valorServico;
        this.tipo = tipo;
    }

    public Servico(String nomeServico, String descricaoServico, double valorServico,
                   TipoServico tipo, int duracaoMinutos) {
        this(nomeServico, valorServico, tipo);
        this.descricaoServico = descricaoServico;
        this.duracaoMinutos = duracaoMinutos;
    }

    public double aplicarDesconto(double percentual) {
        return valorServico - (valorServico * percentual / 100);
    }

    public double calcularPrecoComAcrescimo(double percentual) {
        return valorServico + (valorServico * percentual / 100);
    }

    private double calcularMargemInterna() {
        return valorServico * 0.10;
    }

    public void ajustarPrecoComMargem() {
        double margem = calcularMargemInterna();
        this.valorServico += margem;
    }

    public String formatarDuracao() {
        int horas = duracaoMinutos / 60;
        int minutos = duracaoMinutos % 60;

        if (horas > 0) {
            return horas + "h " + minutos + "min";
        }
        return minutos + " minutos";
    }

    public boolean ehServicoLongo() {
        return duracaoMinutos > 60;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        if (valorServico < 0) {
            System.out.println("ERRO: Valor não pode ser negativo!");
            return;
        }
        this.valorServico = valorServico;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            System.out.println("ATENÇÃO: Duração deve ser maior que zero!");
            return;
        }
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String toString() {
        return nomeServico + " - " + tipo + " = R$" + String.format("%.2f", valorServico) + (duracaoMinutos > 0 ? " - " + formatarDuracao() : "");
    }
}
