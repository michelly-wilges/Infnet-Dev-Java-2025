package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Servico;
import br.edu.infnet.michellyapi.enums.TipoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoService {

    private List<Servico> servicos = new ArrayList<>();

    public void cadastrar(Servico servico) {
        servicos.add(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }

    public List<Servico> listarTodos() {
        return servicos;
    }
    public Servico buscarPorNome(String nome) {
        return servicos.stream()
                .filter(s -> s.getNomeServico().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Servico> buscarPorTipo(TipoServico tipo) {
        return servicos.stream()
                .filter(s -> s.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public List<Servico> buscarPorFaixaPreco(double precoMin, double precoMax) {
        return servicos.stream()
                .filter(s -> s.getValorServico() >= precoMin &&
                        s.getValorServico() <= precoMax)
                .collect(Collectors.toList());
    }

    public double calcularMediaPrecos() {
        return servicos.stream()
                .mapToDouble(Servico::getValorServico)
                .average()
                .orElse(0.0);
    }

    public int contarServicos() {
        return servicos.size();
    }
}
