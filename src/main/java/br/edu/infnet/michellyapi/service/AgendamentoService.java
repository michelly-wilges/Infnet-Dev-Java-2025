package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Agendamento;
import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.entidades.Funcionario;
import br.edu.infnet.michellyapi.enums.StatusAgendamento;
import br.edu.infnet.michellyapi.exceptions.RegraNegocioException;
import br.edu.infnet.michellyapi.interfaces.Cadastro;
import br.edu.infnet.michellyapi.repositorio.CadastroEmMemoria;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoService {

    private final Cadastro<Agendamento> cadastro = new CadastroEmMemoria<>();

    public void adicionar(Agendamento ag) {
        cadastro.cadastrar(ag);
        System.out.println("Agendamento criado com sucesso! ID: " + ag.getId());
    }

    public List<Agendamento> listarTodos() {
        return cadastro.listar();
    }
    public List<Agendamento> buscarPorCliente(Cliente cliente) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorNomeCliente(String nomeCliente) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getCliente().getNomeCliente()
                        .toLowerCase()
                        .contains(nomeCliente.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorFuncionario(Funcionario funcionario) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getFuncionario().equals(funcionario))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorNomeFuncionario(String nomeFuncionario) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getFuncionario().getNomeFuncionario()
                        .toLowerCase()
                        .contains(nomeFuncionario.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorStatus(StatusAgendamento status) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getStatus() == status)
                .collect(Collectors.toList());
    }
    public List<Agendamento> buscarPorData(LocalDate data) {
        return cadastro.listar().stream()
                .filter(ag -> ag.getDataHora() != null &&
                        ag.getDataHora().toLocalDate().equals(data))
                .collect(Collectors.toList());
    }
    public Agendamento buscarPorId(Long id) {
        return cadastro.listar().stream()
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
        throw new RegraNegocioException("Agendamento não encontrado!");
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
        return cadastro.listar().size();
    }
    public int contarPorStatus(StatusAgendamento status) {
        return (int) cadastro.listar().stream()
                .filter(ag -> ag.getStatus() == status)
                .count();
    }
}


