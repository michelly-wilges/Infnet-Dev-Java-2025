package br.edu.infnet.michellyapi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nomeCliente;
    private String telefoneCliente;
    private String cpfCliente;
    private List<Agendamento> historicoAgendamentos;

    public Cliente() {
        this.historicoAgendamentos = new ArrayList<>();
    }

    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente) {
        this();
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        historicoAgendamentos.add(agendamento);
    }

    public int quantidadeAgendamentos() {
        return historicoAgendamentos.size();
    }

    public double calcularTotalGasto() {
        return historicoAgendamentos.stream()
                .mapToDouble(Agendamento::calcularValorTotal)
                .sum();
    }

    public boolean ehClienteFidelizado() {
        return historicoAgendamentos.size() >= 5;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            System.out.println("ATENÇÃO: Nome não pode ser vazio!");
            return;
        }
        this.nomeCliente = nomeCliente.trim();
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        if (telefoneCliente == null || telefoneCliente.length() < 10) {
            System.out.println("ATENÇÃO: Telefone inválido!");
            return;
        }
        this.telefoneCliente = telefoneCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        if (cpfCliente == null || cpfCliente.length() != 11) {
            System.out.println("ATENÇÃO: CPF deve ter 11 dígitos!");
            return;
        }
        this.cpfCliente = cpfCliente;
    }

    public List<Agendamento> getHistoricoAgendamentos() {
        return historicoAgendamentos;
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "CLIENTE" + "\n" +
                "========================================\n" +
                "Nome: " + nomeCliente + "\n" +
                "CPF: " + cpfCliente + "\n" +
                "Telefone: " + telefoneCliente + "\n" +
                "Total de agendamentos: " + quantidadeAgendamentos() + "\n" +
                "Cliente fidelizado: " + (ehClienteFidelizado() ? "SIM" : "NÃO") + "\n" +
                "========================================";
    }
}
