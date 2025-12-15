package br.edu.infnet.michellyapi.interfaces;

import java.util.List;

public interface Cadastro<T> {
    void cadastrar(T obj);
    List<T> listar();
}
