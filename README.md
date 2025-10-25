# Projeto Salão de Beleza - Entrega 1 - Fundamentos de Desenvolvimento com Java

## Informações da Entrega

Este repositório contém o código-fonte referente à **Primeira Entrega** do trabalho da disciplina de **Fundamentos de Desenvolvimento com Java**.

### O que foi solicitado:

1.  **Código-fonte do Projeto:** Estrutura básica da aplicação e ponto de entrada.
2.  **Funcionalidade Mínima:** Implementação do Menu Principal Interativo e das **três** principais classes de **Entidade** (`Cliente`, `Funcionario`, e `Servico`).

---

## Detalhamento da Implementação (Foco desta Etapa)

O foco principal desta entrega foi estabelecer o **esqueleto do projeto** e a **estrutura de dados** inicial, preparando o sistema para as funcionalidades futuras.

### 1. Estrutura de Pacotes

A aplicação foi organizada em pacotes lógicos:

* **`br.edu.infnet.michellyapi`:** Contém a classe principal `MichellyapiApplication`, que inicia a aplicação.
* **`br.edu.infnet.michellyapi.principal`:** Lógica de execução e interação com o usuário (`Principal.java`).
* **`br.edu.infnet.michellyapi.entidades`:** Contém as classes que modelam os dados (**`Cliente`**, **`Funcionario`**).
* **`br.edu.infnet.michellyapi.service`:** Contém a classe que modela os serviços oferecidos (**`Servico`**).

### 2. Implementação das Classes de Dados

Três classes fundamentais foram criadas com a seguinte arquitetura:

| Classe | Pacote | Status da Implementação | Atributos Principais |
| :--- | :--- | :--- | :--- |
| **`Cliente`** | `entidades` | **Completa** | `nomeCliente`, `cpfCliente`, `telefoneCliente`. Inclui **construtor** e **`toString()`**. |
| **`Funcionario`** | `entidades` | Estrutura Básica | `nomeFuncionario`, `cargoFuncionario`, `comissaoFuncionario`. Possui **Getters e Setters**. |
| **`Servico`** | `service` | Estrutura Básica | `nomeServico`, `descricaoServico`, `valorServico`. Possui **Getters e Setters**. |

### 3. Funcionalidade da Classe Principal

A classe `br.edu.infnet.michellyapi.principal.Principal` realiza:
* Exibição do **Menu Simples** ("Cadastro", "Agendamento", "Consulta").
* Processamento inicial da entrada do usuário.
* Demonstração da instanciação de objetos `Cliente`.

---

## Como Executar

O projeto é configurado para rodar como um aplicativo Spring Boot.

1.  **Requisitos:** Java 21 e Maven.
2.  **Execução:** A aplicação pode ser executada a partir da IDE IntelliJ ou via terminal.
