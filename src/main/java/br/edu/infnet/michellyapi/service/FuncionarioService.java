package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public Funcionario buscarPorNome(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNomeFuncionario().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public List<Funcionario> buscarPorNomeParcial(String nomeParcial) {
        return funcionarios.stream()
                .filter(f -> f.getNomeFuncionario()
                        .toLowerCase()
                        .contains(nomeParcial.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }
    public int contarFuncionarios() {
        return funcionarios.size();
    }
    public List<Funcionario> buscarPorCargo(String cargo) {
        return funcionarios.stream()
                .filter(f -> f.getCargoFuncionario()
                        .equalsIgnoreCase(cargo))
                .collect(Collectors.toList());
    }
}
