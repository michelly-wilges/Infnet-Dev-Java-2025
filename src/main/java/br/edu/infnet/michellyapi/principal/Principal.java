package br.edu.infnet.michellyapi.principal;

import br.edu.infnet.michellyapi.entidades.Agendamento;
import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.entidades.Funcionario;
import br.edu.infnet.michellyapi.entidades.Servico;
import br.edu.infnet.michellyapi.enums.FormaPagamento;
import br.edu.infnet.michellyapi.enums.StatusAgendamento;
import br.edu.infnet.michellyapi.enums.TipoServico;
import br.edu.infnet.michellyapi.service.AgendamentoService;
import br.edu.infnet.michellyapi.service.ClienteService;
import br.edu.infnet.michellyapi.service.FuncionarioService;
import br.edu.infnet.michellyapi.service.ServicoService;

import java.util.Scanner;

public class Principal {
    private final Scanner leitura = new Scanner(System.in);
    private final ClienteService clienteService = new ClienteService();
    private final FuncionarioService funcionarioService = new FuncionarioService();
    private final ServicoService servicoService = new ServicoService();
    private final AgendamentoService agendamentoService = new AgendamentoService();
    private int tentativasLogin = 0;
    private boolean usuarioAutenticado = false;

    public void executar() {
        carregarDadosIniciais();
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
    private void carregarDadosIniciais() {
        Cliente c1 = new Cliente("Odete Roitman", "12345678900", "21992345678");
        Cliente c2 = new Cliente("Maria de Fátima Acioly", "78945612300", "21912345678");
        clienteService.cadastrar(c1);
        clienteService.cadastrar(c2);

        Funcionario f1 = new Funcionario("Celina juqueira", "51992345678", "Cabeleireira", 10);
        Funcionario f2 = new Funcionario("Pedrina Alves", "51966665555", "Manicure", 15);
        funcionarioService.cadastrar(f1);
        funcionarioService.cadastrar(f2);

        Servico s1 = new Servico("Corte Feminino", "Corte + Escova", 80.0, TipoServico.CORTE, 60);
        Servico s2 = new Servico("Manicure", "Esmaltação completa", 40.0, TipoServico.MANICURE, 45);
        Servico s3 = new Servico("Coloração", "Coloração completa", 150.0, TipoServico.COLORACAO, 120);
        servicoService.cadastrar(s1);
        servicoService.cadastrar(s2);
        servicoService.cadastrar(s3);

        Agendamento ag1 = new Agendamento(c1, f1, s1);
        ag1.setPagamento(FormaPagamento.PIX);
        agendamentoService.adicionar(ag1);
        c1.adicionarAgendamento(ag1);
        f1.adicionarAtendimento(ag1);

        System.out.println("Dados iniciais carregados!");
        System.out.println(clienteService.contarClientes() + " clientes");
        System.out.println(funcionarioService.contarFuncionarios() + " funcionários");
        System.out.println(servicoService.listarTodos().size() + " serviços");
        System.out.println(agendamentoService.contarAgendamentos() + " agendamentos");
    }

        private void exibirMenu() {
                boolean continuar = true;

                while (continuar) {
                    mostrarOpcoes();
                    String opcao = leitura.nextLine().trim();

                    switch (opcao) {
                        case "1":
                            menuCadastro();
                            break;
                        case "2":
                            menuConsulta();
                            break;
                        case "3":
                            menuListagem();
                            break;
                        case "4":
                            menuServicos();
                            break;
                        case "5":
                            menuAgendamento();
                            break;
                        case "6":
                            menuBuscaAvancada();
                            break;
                        case "0":
                            System.out.println("Finalizando...");
                            continuar = false;
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                    }
                }
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
                  5 - Agendamentos
                  6 - Busca Avançada
                                
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
                cadastrarCliente();
                break;
            case "2":
                cadastrarFuncionario();
                break;
            case "0":
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private void cadastrarCliente() {
        System.out.println("Digite o nome do cliente: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o CPF (apenas números): ");
        String cpf = leitura.nextLine();

        System.out.println("Digite o telefone com DDD: ");
        String telefone = leitura.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone);
        clienteService.cadastrar(cliente);
    }

    private void cadastrarFuncionario() {
        Funcionario f = new Funcionario();

        System.out.println("Digite o nome do funcionário: ");
        f.setNomeFuncionario(leitura.nextLine());

        System.out.println("Digite o telefone com DDD: ");
        f.setTelefoneFuncionario(leitura.nextLine());

        System.out.println("Digite o cargo: ");
        f.setCargoFuncionario(leitura.nextLine());

        System.out.println("Digite o valor da comissão (%): ");
        f.setComissaoFuncionario(Integer.parseInt(leitura.nextLine()));

        funcionarioService.cadastrar(f);
    }

    private void menuConsulta() {

            System.out.println("""
                ======================================================
                                      CONSULTA
                ======================================================
                
                  1 - Cliente por CPF
                  2 - Funcionário por nome
                
                  Digite o número da opção desejada ou 0 para voltar ao menu principal: 
                
                """);

            String opcao = leitura.nextLine().trim();

            switch (opcao) {
                case "1":
                    consultarClientePorCpf();
                    break;
                case "2":
                    consultarFuncionarioPorNome();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        private void consultarClientePorCpf() {
            System.out.println("Digite o CPF (apenas números): ");
            String cpf = leitura.nextLine();

            Cliente c = clienteService.buscarPorCpf(cpf);

            if (c == null) {
                System.out.println("Cliente não encontrado.");
            } else {
                System.out.println(c);
            }
        }

        private void consultarFuncionarioPorNome() {
            System.out.println("Digite o nome: ");
            String nome = leitura.nextLine();

            Funcionario f = funcionarioService.buscarPorNome(nome);

            if (f == null) {
                System.out.println("Atenção: funcionário não encontrado!");
            } else {
                System.out.println(f);
            }
        }

    private void menuListagem() {
        System.out.println("""
                ======================================================
                                      LISTAGEM
                ======================================================
                
                  1 - Clientes
                  2 - Funcionários
                  3 - Serviços
                  4 - Agendamentos
                                
                  Digite o número da opção desejada ou 0 para voltar ao menu principal: 
                
                """);

        String opcao = leitura.nextLine().trim();

        switch (opcao) {
            case "1":
                clienteService.listarTodos().forEach(System.out::println);
                break;
            case "2":
                funcionarioService.listarTodos()
                        .forEach(f -> System.out.println(f.getNomeFuncionario()));
                break;
            case "3":
                servicoService.listarTodos()
                        .forEach(s -> System.out.println(s.getNomeServico()));
                break;
            case "4":
                listarAgendamentos();
                break;
            case "0":
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
    private void listarClientes() {
        var clientes = clienteService.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Total: " + clientes.size() + " cliente(s).");
            clientes.forEach(System.out::println);
        }
    }

    private void listarFuncionarios() {
        var funcionarios = funcionarioService.listarTodos();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Total: " + funcionarios.size() + " funcionário(s).");
            funcionarios.forEach(System.out::println);
        }
    }

    private void listarServicos() {
        var servicos = servicoService.listarTodos();

        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            System.out.println("Total: " + servicos.size() + " serviço(s).");
            servicos.forEach(System.out::println);
        }
    }

    private void menuServicos() {
        System.out.println("""
                ======================================================
                                      SERVIÇOS
                ======================================================
                
                  1 - Cadastrar serviço
                  2 - Listar serviços
                               
                  Digite o número da opção desejada ou 0 para voltar ao menu principal: 
                
                """);
        String opcao = leitura.nextLine().trim();

        switch (opcao) {
            case "1":
                cadastrarServico();
                break;
            case "2":
                listarServicos();
                break;
            case "0":
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

private void cadastrarServico() {
    Servico s = new Servico();

    System.out.println("Nome do serviço: ");
    s.setNomeServico(leitura.nextLine());

    System.out.println("Descrição: ");
    s.setDescricaoServico(leitura.nextLine());

    System.out.println("Valor: ");
    s.setValorServico(Double.parseDouble(leitura.nextLine()));

    System.out.println("Duração em minutos: ");
    s.setDuracaoMinutos(Integer.parseInt(leitura.nextLine()));

    System.out.println("""
                ======================================================
                                    TIPO DE SERVIÇO
                ======================================================
                
                  1 - Corte
                  2 - Manicure
                  3 - Pedicure
                  4 - Coloração
                  5 - Sobrancelha
                               
                  Digite o número da opção desejada ou 0 para voltar ao menu principal: 
                
                """);
    int opcaoTipo = Integer.parseInt(leitura.nextLine());

    switch (opcaoTipo) {
        case 1:
            s.setTipo(TipoServico.CORTE);
            break;
        case 2:
            s.setTipo(TipoServico.MANICURE);
            break;
        case 3:
            s.setTipo(TipoServico.PEDICURE);
            break;
        case 4:
            s.setTipo(TipoServico.COLORACAO);
            break;
        case 5:
            s.setTipo(TipoServico.SOBRANCELHA);
            break;
        default:
            System.out.println("Opção inválida! Tente novamente.");
        }

    servicoService.cadastrar(s);
}

    private void menuAgendamento() {
        System.out.println("""
                ======================================================
                                    AGENDAMENTOS
                ======================================================
                
                  1 - Criar agendamento
                  2 - Listar agendamentos
                  3 - Buscar por cliente
                  4 - Buscar por funcionário
                  5 - Confirmar agendamento
                  6 - Cancelar agendamento
                
                  Digite o número da opção desejada ou 0 para voltar: 
                
                """);

        String opcao = leitura.nextLine().trim();

        switch (opcao) {
            case "1":
                criarAgendamento();
                break;
            case "2":
                listarAgendamentos();
                break;
            case "3":
                buscarAgendamentoPorCliente();
                break;
            case "4":
                buscarAgendamentoPorFuncionario();
                break;
            case "5":
                confirmarAgendamento();
                break;
            case "6":
                cancelarAgendamento();
                break;
            case "0":
                return;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private void criarAgendamento() {
        System.out.println("Digite o CPF do cliente: ");
        String cpf = leitura.nextLine();
        Cliente cliente = clienteService.buscarPorCpf(cpf);

        if (cliente == null) {
            System.out.println("Atenção: cliente não encontrado!");
        } else {
            System.out.println("Digite o nome do funcionário: ");
            String nomeFuncionario = leitura.nextLine();
            Funcionario funcionario = funcionarioService.buscarPorNome(nomeFuncionario);
            if (funcionario == null) {
               System.out.println("Atenção: funcionário não encontrado!");
            } else {
               System.out.println("--- Serviços Disponíveis ---\n");
               var servicos = servicoService.listarTodos();
               if (servicos.isEmpty()) {
                   System.out.println("Atenção: nenhum serviço cadastrado!");
               } else {
                   for (int i = 0; i < servicos.size(); i++) {
                      System.out.println((i + 1) + " - " + servicos.get(i));
                   }
                   System.out.println("Escolha o número do serviço: ");
                   int indiceServico = Integer.parseInt(leitura.nextLine()) - 1;
                   if (indiceServico < 0 || indiceServico >= servicos.size()) {
                       System.out.println("Atenção: serviço inválido!");
                   } else {
                       Servico servico = servicos.get(indiceServico);
                       Agendamento agendamento = new Agendamento(cliente, funcionario, servico);
                       System.out.println("""
                                    ======================================================
                                                       FORMA DE PAGAMENTO
                                    ======================================================
                                    
                                      1 - Dinheiro
                                      2 - Pix
                                      3 - Cartão de Crédito
                                      4 - Cartão de Débito
                                    
                                      Digite o número da opção desejada ou 0 para voltar: 
                                    
                                    """);
                            int opcaoPagamento = Integer.parseInt(leitura.nextLine());
                            switch (opcaoPagamento) {
                                case 1:
                                    agendamento.setPagamento(FormaPagamento.DINHEIRO);
                                    break;
                                case 2:
                                    agendamento.setPagamento(FormaPagamento.PIX);
                                    break;
                                case 3:
                                    agendamento.setPagamento(FormaPagamento.CARTAO_CREDITO);
                                    break;
                                case 4:
                                    agendamento.setPagamento(FormaPagamento.CARTAO_DEBITO);
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");
                            }
                            agendamentoService.adicionar(agendamento);
                            cliente.adicionarAgendamento(agendamento);
                            funcionario.adicionarAtendimento(agendamento);
                            System.out.println("Agendamento criado com sucesso!");
                            System.out.println(agendamento);
                        }
               }
            }
        }
    }

        private void listarAgendamentos() {
            var agendamentos = agendamentoService.listarTodos();

            if (agendamentos.isEmpty()) {
                System.out.println("Nenhum agendamento cadastrado.");
            } else {
                System.out.println("Total: " + agendamentos.size() + " agendamento(s)");
                agendamentos.forEach(System.out::println);
            }
        }
        private void buscarAgendamentoPorCliente() {
            System.out.println("Digite o nome do cliente: ");
            String nome = leitura.nextLine().trim();

            var agendamentos = agendamentoService.buscarPorNomeCliente(nome);

            if (agendamentos.isEmpty()) {
                System.out.println("Atenção: nenhum agendamento encontrado para este cliente.");
            } else {
                System.out.println("Foram encontrados " + agendamentos.size() + " agendamentos.");
                agendamentos.forEach(System.out::println);
            }
        }

        private void buscarAgendamentoPorFuncionario() {
            System.out.println("Digite o nome do funcionário: ");
            String nome = leitura.nextLine().trim();

            Funcionario f = funcionarioService.buscarPorNome(nome);

            if (f == null) {
                System.out.println("Atenção: funcionário não encontrado!");
                return;
            }

            var agendamentos = agendamentoService.buscarPorFuncionario(f);

            if (agendamentos.isEmpty()) {
                System.out.println("Atenção: nenhum agendamento encontrado para este funcionário.");
            } else {
                System.out.println("Foram encontrados " + agendamentos.size() + " agendamentos.");
                agendamentos.forEach(System.out::println);
            }
        }

        private void confirmarAgendamento() {

            var pendentes = agendamentoService.buscarPorStatus(StatusAgendamento.PENDENTE);

            if (pendentes.isEmpty()) {
                System.out.println("Atenção: nenhum agendamento pendente.");
                return;
            }

            System.out.println("--- Agendamentos Pendentes ---\n");
            pendentes.forEach(ag -> {
                System.out.println("ID: " + ag.getId() + " - Cliente: " +
                        ag.getCliente().getNomeCliente() + " - Serviço: " +
                        ag.getServico().getNomeServico());
            });

            System.out.println("Digite o ID do agendamento para confirmar: ");
            Long id = Long.parseLong(leitura.nextLine());

            agendamentoService.confirmar(id);
        }

        private void cancelarAgendamento() {

            var agendamentos = agendamentoService.listarTodos().stream()
                    .filter(ag -> ag.getStatus() != StatusAgendamento.CANCELADO)
                    .toList();

            if (agendamentos.isEmpty()) {
                System.out.println("Atenção: nenhum agendamento ativo.");
                return;
            }

            System.out.println("--- Agendamentos Ativos ---\n");
            agendamentos.forEach(ag -> {
                System.out.println("ID: " + ag.getId() + " - Cliente: " +
                        ag.getCliente().getNomeCliente() + " - Status: " +
                        ag.getStatus());
            });

            System.out.println("Digite o ID do agendamento para cancelar: ");
            Long id = Long.parseLong(leitura.nextLine());

            agendamentoService.cancelar(id);
        }

        private void menuBuscaAvancada() {
            System.out.println("""
                ======================================================
                                     BUSCA AVANÇADA
                ======================================================
                
                  Digite o tipo de busca:
                  - "cad" para buscar cadastros
                  - "age" para buscar agendamentos
                  - ou qualquer outra coisa para buscar cliente
                
                """);

            String opcao = leitura.nextLine().trim();

            if (opcao.toLowerCase().contains("cad")) {
                buscarCadastro();
            } else if (opcao.toLowerCase().contains("age")) {
                buscarAgendamentoPorFuncionario();
            } else {
                buscarClientePorNome();
            }
        }

        private void buscarClientePorNome() {
            System.out.println("Digite o nome do cliente para consultar: ");
            String nome = leitura.nextLine().trim();

            var clientes = clienteService.buscarPorNomeParcial(nome);

            if (clientes.isEmpty()) {
                System.out.println("Atenção: nenhum cliente encontrado com esse nome.");
            } else if (clientes.size() == 1) {
                System.out.println(clientes.get(0));
            } else {
                System.out.println("Foram encontrados " + clientes.size() + " clientes: ");
                clientes.forEach(System.out::println);
            }
        }

        private void buscarCadastro() {
            System.out.println("Digite 1 para Cliente ou 2 para Funcionário: ");
            String tipo = leitura.nextLine().trim();

            if (tipo.equals("1")) {
                consultarClientePorCpf();
            } else if (tipo.equals("2")) {
                consultarFuncionarioPorNome();
            } else {
                System.out.println("Atenção: opção inválida!");
            }
        }
    }