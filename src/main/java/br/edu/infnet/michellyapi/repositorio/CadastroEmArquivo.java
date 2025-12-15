package br.edu.infnet.michellyapi.repositorio;

import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.interfaces.Cadastro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroEmArquivo implements Cadastro<Cliente> {
    private static final String ARQUIVO = "clientes.txt";

    @Override
    public void cadastrar(Cliente cliente) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ARQUIVO, true));
            writer.write(cliente.getNomeCliente() + ";" + cliente.getCpfCliente() + ";" + cliente.getTelefoneCliente());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Cliente não pode ser salvo no arquivo.");
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Não foi possível fechar o arquivo.");
            }
        }
    }
    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(ARQUIVO));
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Cliente c = new Cliente(dados[0], dados[1], dados[2]);
                clientes.add(c);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo.");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Não foi possível fechar o arquivo.");
            }
        }
        return clientes;
    }
}
