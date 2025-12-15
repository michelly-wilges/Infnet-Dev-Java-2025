package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.exceptions.RegraNegocioException;
import br.edu.infnet.michellyapi.interfaces.Cadastro;
import br.edu.infnet.michellyapi.repositorio.CadastroEmArquivo;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {
    private final Cadastro<Cliente> cadastroArquivo = new CadastroEmArquivo();

    public void cadastrar(Cliente cliente) {
        if (buscarPorCpf(cliente.getCpfCliente()) != null) {
            throw new RegraNegocioException("CPF já cadastrado!");
        }
        cadastroArquivo.cadastrar(cliente);
        System.out.println("Cliente salvo em arquivo!");
    }

    public Cliente buscarPorCpf(String cpf) {
       return cadastroArquivo.listar().stream().filter(c -> c.getCpfCliente().equalsIgnoreCase(cpf)).findFirst().orElse(null);
    }

    public Cliente buscarPorNome(String nome) {
       return cadastroArquivo.listar().stream().filter(c -> c.getNomeCliente().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public List<Cliente> buscarPorNomeParcial(String nomeParcial) {
        return cadastroArquivo.listar().stream()
                .filter(c -> c.getNomeCliente()
                        .toLowerCase()
                        .contains(nomeParcial.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Cliente> listarTodos() {
        return cadastroArquivo.listar();
    }

    public boolean existeClienteComCpf(String cpf) {
        return buscarPorCpf(cpf) != null;
    }

    public int contarClientes() {
        return listarTodos().size();
    }

    public List<Cliente> listarClientesFidelizados() {
        return cadastroArquivo.listar().stream()
                .filter(Cliente::ehClienteFidelizado)
                .collect(Collectors.toList());
    }
}
