package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente cliente) {
        if (buscarPorCpf(cliente.getCpfCliente()) != null) {
            System.out.println("ERRO: CPF já cadastrado!");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpfCliente().equalsIgnoreCase(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarPorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNomeCliente().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> buscarPorNomeParcial(String nomeParcial) {
        return clientes.stream()
                .filter(c -> c.getNomeCliente()
                        .toLowerCase()
                        .contains(nomeParcial.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public boolean existeClienteComCpf(String cpf) {
        return buscarPorCpf(cpf) != null;
    }

    public int contarClientes() {
        return clientes.size();
    }

    public List<Cliente> listarClientesFidelizados() {
        return clientes.stream()
                .filter(Cliente::ehClienteFidelizado)
                .collect(Collectors.toList());
    }
}
