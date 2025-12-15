package br.edu.infnet.michellyapi.entidades;

public abstract class Pessoa {
    protected String nome;
    protected String telefone;

    protected Pessoa() {
    }

    protected Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo nome não pode ser vazio.");
        }
        this.nome = nome.trim();
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.length() < 10) {
            throw new IllegalArgumentException("Digite o telefone com DDD.");
        }
        this.telefone = telefone;
    }

    public abstract String getTipoPessoa();

    @Override
    public String toString() {
        return "Nome: " + nome + " - Telefone: " + telefone;
    }
}
