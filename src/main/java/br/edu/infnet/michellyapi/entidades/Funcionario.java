package br.edu.infnet.michellyapi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String cargoFuncionario;
    private Integer comissaoFuncionario;
    private List<Servico> especialidades;
    private List<Agendamento> atendimentos;

    public Funcionario() {
        this.especialidades = new ArrayList<>();
        this.atendimentos = new ArrayList<>();
    }

    public Funcionario(String nomeFuncionario, String telefoneFuncionario, String cargoFuncionario, Integer comissaoFuncionario) {
        this();
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.comissaoFuncionario = comissaoFuncionario;
    }

    public void adicionarEspecialidade(Servico servico) {
        if (!especialidades.contains(servico)) {
            especialidades.add(servico);
            System.out.println("Especialidade adicionada: " + servico.getNomeServico());
        }
    }

    public void adicionarAtendimento(Agendamento agendamento) {
        atendimentos.add(agendamento);
    }

    public double calcularTotalComissao() {
        double totalVendas = atendimentos.stream()
                .mapToDouble(Agendamento::calcularValorTotal)
                .sum();
        return totalVendas * (comissaoFuncionario / 100.0);
    }

    public int quantidadeAtendimentos() {
        return atendimentos.size();
    }

    public boolean possuiEspecialidade(Servico servico) {
        return especialidades.contains(servico);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public Integer getComissaoFuncionario() {
        return comissaoFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public void setComissaoFuncionario(Integer comissaoFuncionario) {
        if (comissaoFuncionario < 0 || comissaoFuncionario > 100) {
            System.out.println("ATENÇÃO: Comissão deve estar entre 0 e 100%");
            return;
        }
        this.comissaoFuncionario = comissaoFuncionario;
    }

    public List<Servico> getEspecialidades() {
        return especialidades;
    }

    public List<Agendamento> getAtendimentos() {
        return atendimentos;
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "FUNCIONÁRIO" + "\n" +
                "========================================\n" +
                "Nome: " + nomeFuncionario + "\n" +
                "Cargo: " + cargoFuncionario + "\n" +
                "Telefone: " + telefoneFuncionario + "\n" +
                "Comissão: " + comissaoFuncionario + "%" + "\n" +
                "Atendimentos realizados: " + quantidadeAtendimentos() + "\n" +
                "========================================";
    }
}
