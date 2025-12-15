package br.edu.infnet.michellyapi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String cpfCliente;
    private List<Agendamento> historicoAgendamentos;
    private boolean clienteVIP;
    private double saldoCredito;

    public Cliente() {
        this.historicoAgendamentos = new ArrayList<>();
    }

    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente) {
        super(nomeCliente, telefoneCliente);
        this.cpfCliente = cpfCliente;
        this.historicoAgendamentos = new ArrayList<>();
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

    public void atualizarStatusVIP() {
        this.clienteVIP = ehClienteFidelizado();
    }

    public String getNomeCliente() {
        return getNome();
    }

    public void setNomeCliente(String nomeCliente) {
        setNome(nomeCliente);
    }

    public String getTelefoneCliente() {
        return getTelefone();
    }

    public void setTelefoneCliente(String telefoneCliente) {
        setTelefone(telefoneCliente);
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        if (cpfCliente == null || cpfCliente.length() != 11) {
            throw new IllegalArgumentException("ATENÇÃO: CPF deve ter 11 dígitos!");
        }
        this.cpfCliente = cpfCliente;
    }

    public boolean isClienteVIP() {
        return clienteVIP;
    }

    public void setClienteVIP(boolean clienteVIP) {
        this.clienteVIP = clienteVIP;
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }

    public void adicionarCredito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de crédito inválido.");
            return;
        }
        this.saldoCredito += valor;
    }


    public List<Agendamento> getHistoricoAgendamentos() {
        return historicoAgendamentos;
    }

    @Override
    public String getTipoPessoa() {
        return "Cliente";
    }
    @Override
    public String toString() {
        return "========================================\n" +
                "CLIENTE" + "\n" +
                "========================================\n" +
                "Nome: " + getNomeCliente() + "\n" +
                "CPF: " + cpfCliente + "\n" +
                "Telefone: " + getTelefoneCliente() + "\n" +
                "Total de agendamentos: " + quantidadeAgendamentos() + "\n" +
                "Cliente VIP: " + (clienteVIP ? "SIM" : "NÃO") + "\n" +
                "Saldo de crédito: R$ " + String.format("%.2f", saldoCredito) + "\n" +
                "========================================";
    }
}
