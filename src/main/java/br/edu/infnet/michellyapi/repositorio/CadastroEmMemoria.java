package br.edu.infnet.michellyapi.repositorio;

import br.edu.infnet.michellyapi.interfaces.Cadastro;

import java.util.ArrayList;
import java.util.List;

public class CadastroEmMemoria<T> implements Cadastro<T> {
    private final List<T> dados = new ArrayList<>();

    @Override
    public void cadastrar(T obj) {
        dados.add(obj);
    }

    @Override
    public List<T> listar() {
        return dados;
    }
}
