package br.edu.infnet.michellyapi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    private String cargoFuncionario;
    private Integer comissaoFuncionario;
    private List<Servico> especialidades;
    private List<Agendamento> atendimentos;

    public Funcionario() {
        this.especialidades = new ArrayList<>();
        this.atendimentos = new ArrayList<>();
    }

    public Funcionario(String nomeFuncionario, String telefoneFuncionario, String cargoFuncionario, Integer comissaoFuncionario) {
        super(nomeFuncionario, telefoneFuncionario);
        this.cargoFuncionario = cargoFuncionario;
        this.comissaoFuncionario = comissaoFuncionario;
        this.especialidades = new ArrayList<>();
        this.atendimentos = new ArrayList<>();
    }

    public String getNomeFuncionario() {
        return getNome();
    }

    public String getTelefoneFuncionario() {
        return getTelefone();
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public Integer getComissaoFuncionario() {
        return comissaoFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        setNome(nomeFuncionario);
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        setTelefone(telefoneFuncionario);
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public void setComissaoFuncionario(Integer comissaoFuncionario) {
        if (comissaoFuncionario < 0 || comissaoFuncionario > 100) {
            throw new IllegalArgumentException("ATENÇÃO: Comissão deve estar entre 0 e 100%");
        }
        this.comissaoFuncionario = comissaoFuncionario;
    }
    public int quantidadeAtendimentos() {
        return atendimentos.size();
    }

    public boolean possuiEspecialidade(Servico servico) {
        return especialidades.contains(servico);
    }
    public List<Servico> getEspecialidades() {
        return especialidades;
    }

    public List<Agendamento> getAtendimentos() {
        return atendimentos;
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

    @Override
    public String getTipoPessoa() {
        return "Funcionário";
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "FUNCIONÁRIO" + "\n" +
                "========================================\n" +
                super.toString() + "\n" +
                "Cargo: " + cargoFuncionario + "\n" +
                "Comissão: " + comissaoFuncionario + "%" + "\n" +
                "Atendimentos realizados: " + quantidadeAtendimentos() + "\n" +
                "========================================";
    }
}
