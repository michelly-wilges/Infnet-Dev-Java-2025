package br.edu.infnet.michellyapi.testes;

import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.entidades.Funcionario;
import br.edu.infnet.michellyapi.entidades.Servico;
import br.edu.infnet.michellyapi.exceptions.RegraNegocioException;
import br.edu.infnet.michellyapi.service.ClienteService;
import br.edu.infnet.michellyapi.service.FuncionarioService;
import br.edu.infnet.michellyapi.service.ServicoService;
import br.edu.infnet.michellyapi.service.PessoaService;
import br.edu.infnet.michellyapi.entidades.Pessoa;

public class ClasseParaTestes {
    public static void executarTestes() {

        System.out.println("Iniciando Testes");

        System.out.println("ClienteService()");
        ClienteService clienteService = new ClienteService();

        Cliente c1 = new Cliente("Cliente Um", "12345678910", "21987654321");
        Cliente c2 = new Cliente("Cliente Dois", "11335577990", "51998765432");

        clienteService.cadastrar(c1);
        clienteService.cadastrar(c2);

        try {
            clienteService.cadastrar(c1);
            clienteService.cadastrar(c2);
        } catch (RegraNegocioException e) {
            System.out.println("[Teste] " + e.getMessage());
        }

        System.out.println(clienteService.buscarPorCpf("12345678910"));
        System.out.println(clienteService.buscarPorCpf("11335577990"));

        System.out.println("FuncionarioService()");
        FuncionarioService funcionarioService = new FuncionarioService();

        Funcionario f = new Funcionario();
            f.setNomeFuncionario("Leila");
            f.setTelefoneFuncionario("51988776655");
            f.setCargoFuncionario("Cabeleireira");
            f.setComissaoFuncionario(10);

            funcionarioService.cadastrar(f);
            System.out.println(funcionarioService.buscarPorNome("Leila"));

        PessoaService pessoaService = new PessoaService();

        Cliente cliente = new Cliente("Ana", "12345678901", "21999999999");
        Funcionario funcionario = new Funcionario("Bruno", "51988888888", "Barbeiro", 10);

        pessoaService.cadastrar(cliente);
        pessoaService.cadastrar(funcionario);

        pessoaService.imprimirResumo();

        System.out.println("ServicoService()");
        ServicoService servicoService = new ServicoService();

        Servico s1 = new Servico();
            s1.setNomeServico("Corte Feminino");
            s1.setDescricaoServico("Corte + Escova");
            s1.setValorServico(80.0);

            servicoService.cadastrar(s1);

            servicoService.listarTodos().forEach(System.out::println);

            System.out.println("Testes Finalizados");
    }
}