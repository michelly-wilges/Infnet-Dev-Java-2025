package br.edu.infnet.michellyapi.principal;

import br.edu.infnet.michellyapi.entidades.Cliente;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var menu = """
                ==== SALÃO DE BELEZA ====
                *** OPÇÕES ***
                Cadastro
                Agendamento
                Consulta
                
                Digite uma das opções: 
                
                """;

        System.out.println(menu);

        var opcao = leitura.nextLine();

        if (opcao.toLowerCase().contains("cad")) {
            System.out.println("Digite 1 para Cliente e 2 para Funcionário: ");
        } else if (opcao.toLowerCase().contains("age")) {
            System.out.println("Digite o nome do funcionário: ");
        } else {
            System.out.println("Digite o nome do cliente para consultar: ");        }

        Cliente cliente1 = new Cliente("Odete Roitman", "123.456.789-00", "(21)99234-5678");
        Cliente cliente2 = new Cliente("Maria de Fátima Acioly", "789.456.123-00", "(21)91234-5678");
        Cliente cliente3 = new Cliente("Celina juqueira","456.123.789-00", "(51)99234-5678");

        System.out.println(cliente1);
    }

}
