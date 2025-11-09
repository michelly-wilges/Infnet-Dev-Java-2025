package br.edu.infnet.michellyapi.principal;

import br.edu.infnet.michellyapi.entidades.*;
//import br.edu.infnet.michellyapi.service.*;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
//    private ClienteService clienteService = new ClienteService();
//    private FuncionarioService funcionarioService = new FuncionarioService();
//    private ServicoService servicoService = new ServicoService();
    private int tentativasLogin = 0;
    private boolean usuarioAutenticado = false;

    public void executar() {
        String senhaAdmin = "admin123";
        boolean loginAutorizado = false;

        do {
            System.out.println("Digite a senha de acesso: ");
            String senha = leitura.nextLine();
            tentativasLogin++;

            if (senha.equals(senhaAdmin)) {
                loginAutorizado = true;
                usuarioAutenticado = true;
                System.out.println("Seja bem-vido!");
            } else {
                System.out.println("Login não autorizado! Você tem " + (3 - tentativasLogin) + " tentativa(s).");
                if (tentativasLogin >= 3) {
                    System.out.println("Você excedeu o número possível de tentativas de login!");
                    break;
                }
            }
        } while (!loginAutorizado && tentativasLogin < 3);

        if (loginAutorizado && usuarioAutenticado) {
            exibirMenu();
        } else {
            System.out.println("Acesso não autorizado! Finalizando...");
        }
    }

    public void exibirMenu() {
        boolean continuar = true;

        while (continuar) {
            mostrarOpcoes();
            String opcao = leitura.nextLine().trim();

            switch (opcao) {
                case "1":
                    menuCadastro();
                    break;
                case "2":
//                    menuConsulta();
                    break;
                case "3":
//                    menuListagem();
                    break;
                case "4":
//                    menuServicos();
                    break;
                case "0":
                    System.out.println("Finalizando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        leitura.close();
    }

    private void mostrarOpcoes() {
        System.out.println("""
                ======================================================
                                   SALÃO DE BELEZA
                ======================================================
                
                  1 - Cadastros
                  2 - Consultas
                  3 - Listagens
                  4 - Serviços
                                
                  Digite o número da opção desejada ou 0 para sair: 
                
                """);
    }

    private void menuCadastro() {
        System.out.println("""
                ======================================================
                                      CADASTROS
                ======================================================
                
                  1 - Cliente
                  2 - Funcionário
                
                  Digite o número da opção desejada ou 0 para voltar ao menu principal: 
                
                """);

        String opcao = leitura.nextLine().trim();

        switch (opcao) {
            case "1":
//                cadastrarCliente();
                break;
            case "2":
//                cadastrarFuncionario();
                break;
            case "0":
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
}
