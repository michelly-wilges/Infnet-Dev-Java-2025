package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
    public List<Pessoa> listarTodas() {
        return pessoas;
    }
    public void imprimirResumo() {
        for (Pessoa p : pessoas) {
            System.out.println(p.getTipoPessoa() + " - " + p.getNome());
        }
    }
}
