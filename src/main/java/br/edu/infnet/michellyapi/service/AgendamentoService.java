package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Agendamento;
import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.entidades.Funcionario;
import br.edu.infnet.michellyapi.enums.StatusAgendamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoService {

    private List<Agendamento> agendamentos = new ArrayList<>();

    public void adicionar(Agendamento ag) {
        agendamentos.add(ag);
        System.out.println("Agendamento criado com sucesso! ID: " + ag.getId());
    }

    public List<Agendamento> listarTodos() {
        return agendamentos;
    }
    public List<Agendamento> buscarPorCliente(Cliente cliente) {
        return agendamentos.stream()
                .filter(ag -> ag.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorNomeCliente(String nomeCliente) {
        return agendamentos.stream()
                .filter(ag -> ag.getCliente().getNomeCliente()
                        .toLowerCase()
                        .contains(nomeCliente.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorFuncionario(Funcionario funcionario) {
        return agendamentos.stream()
                .filter(ag -> ag.getFuncionario().equals(funcionario))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorNomeFuncionario(String nomeFuncionario) {
        return agendamentos.stream()
                .filter(ag -> ag.getFuncionario().getNomeFuncionario()
                        .toLowerCase()
                        .contains(nomeFuncionario.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorStatus(StatusAgendamento status) {
        return agendamentos.stream()
                .filter(ag -> ag.getStatus() == status)
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorData(LocalDate data) {
        return agendamentos.stream()
                .filter(ag -> ag.getDataHora() != null &&
                        ag.getDataHora().toLocalDate().equals(data))
                .collect(Collectors.toList());
    }
    public Agendamento buscarPorId(Long id) {
        return agendamentos.stream()
                .filter(ag -> ag.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public boolean confirmar(Long id) {
        Agendamento ag = buscarPorId(id);
        if (ag != null) {
            ag.confirmar();
            return true;
        }
        System.out.println("Agendamento não encontrado!");
        return false;
    }
    public boolean cancelar(Long id) {
        Agendamento ag = buscarPorId(id);
        if (ag != null) {
            ag.cancelar();
            return true;
        }
        System.out.println("Agendamento não encontrado!");
        return false;
    }
    public int contarAgendamentos() {
        return agendamentos.size();
    }
    public int contarPorStatus(StatusAgendamento status) {
        return (int) agendamentos.stream()
                .filter(ag -> ag.getStatus() == status)
                .count();
    }
}


