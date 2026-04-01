# Projeto Salão de Beleza

**Fundamentos de Desenvolvimento com Java – Back-end**

Este repositório contém a evolução do projeto **Salão de Beleza**, desenvolvido ao longo das entregas da disciplina **Fundamentos de Desenvolvimento com Java**, utilizando **Spring Boot** e conceitos de **Programação Orientada a Objetos (POO)**.

---

### Entregas Desenvolvidas

### Entrega 1 – Estrutura Inicial
- Criação do projeto Spring Boot
- Definição da estrutura de pacotes
- Implementação das entidades iniciais (`Cliente`, `Funcionario`, `Servico`)
- Menu simples de interação via console

---

### Entrega 2 – Controle de Fluxo
- Uso de estruturas `if / else`
- Menus com `switch-case`
- Laços `while` e `do-while`
- Uso de `break` e `continue`
- Sistema de autenticação simples com tentativas limitadas

---

### Entrega 3 – Programação Orientada a Objetos (POO)

Aplicação dos pilares da Programação Orientada a Objetos:

- **Encapsulamento**
  - Atributos privados
  - Getters e setters com validação
- **Construtores**
  - Construtor padrão
  - Construtores com parâmetros
  - Encadeamento de construtores (`this`)
- **Relacionamentos entre classes**
  - `Agendamento` relaciona `Cliente`, `Funcionario` e `Servico`
- **Enum**
  - `StatusAgendamento`, `TipoServico`, `FormaPagamento`, `NivelAcesso`
- **Coleções**
  - Uso de `List` e `ArrayList`
- **Sobrecarga de métodos**
  - Métodos com e sem parâmetros para cálculos e buscas
- **Testes de comportamento**
  - Classe `ClasseParaTestes`, executada no método `run()` da aplicação

---

### Entrega 4 – Evolução do Projeto (Feedback do Professor)

#### Melhorias implementadas

- **Atributos adicionais na entidade Cliente**
  - Inclusão de atributos dos tipos exigidos:
    - `boolean clienteVIP`
    - `double saldoCredito`
- **Interação entre método público e privado**
  - Implementado na classe `Servico`:
    - Método privado `calcularMargemInterna()`
    - Método público `ajustarPrecoComMargem()`
- **Uso explícito do `continue`**
  - Implementado na listagem de agendamentos, ignorando registros cancelados
- **Tratamento de exceções**
  - Criação da exceção personalizada `RegraNegocioException`
  - Uso de `try-catch` no fluxo de cadastro
- **Abstração e Interfaces**
  - Interface genérica `Cadastro<T>`
  - Implementações em memória e em arquivo
- **Manipulação de arquivos**
  - Persistência de dados utilizando classes de I/O
- **Separação de responsabilidades**
  - `Principal`: interação com o usuário
  - `Service`: regras de negócio
  - `Repositorio`: persistência de dados

---

## 📁 Estrutura de Pacotes

```text
br.edu.infnet.michellyapi
├── entidades/
│   ├── Pessoa.java
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Servico.java
│   └── Agendamento.java
│
├── enums/
│   ├── FormaPagamento.java
│   ├── NivelAcesso.java
│   ├── StatusAgendamento.java
│   └── TipoServico.java
│
├── interfaces/
│   └── Cadastro.java
│
├── repositorio/
│   ├── CadastroEmMemoria.java
│   └── CadastroEmArquivo.java
│
├── service/
│   ├── ClienteService.java
│   ├── FuncionarioService.java
│   ├── ServicoService.java
│   ├── AgendamentoService.java
│   └── AutenticacaoService.java
│
├── principal/
│   └── Principal.java
│
├── testes/
│   └── ClasseParaTestes.java
│
└── MichellyapiApplication.java
```

---

## 🚀 Como Executar

### Requisitos
- **Java 21+**
- **Maven**
- **IDE** (recomendado: IntelliJ IDEA)
- **Execute a classe:**
   - `MichellyapiApplication.java`  

👉 O sistema executa testes de comportamento e exibe o menu interativo no console  

---


## 👨‍💻 Autor

**Michelly** - Bloco Desenvolvimento Back-end [25E4-26E1].

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte do curso de Fundamentos de Desenvolvimento com Java.
