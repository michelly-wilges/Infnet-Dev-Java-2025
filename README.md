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

# Projeto Salão de Beleza - Entrega 2 - Fundamentos de Desenvolvimento com Java

## 📋 Informações da Entrega

1. **Tomada de decisão condicional**: Implementação de estruturas `if`, `else if` e `else` com operadores lógicos
2. **Escolha múltipla com switch-case**: Organização de menus e seleção de opções
3. **Laços de repetição**: Implementação de `for`, `while` e `do-while`
4. **Controle de fluxo**: Uso de `break` e `continue` para controle de iterações

---


Este repositório contém o código-fonte referente à **Segunda Entrega** do trabalho da disciplina de Fundamentos de Desenvolvimento com Java.

### O que foi solicitado:

## 🎯 Detalhamento da Implementação (Entrega 2)

O foco desta entrega foi implementar **estruturas de controle de fluxo** completas.

### 1. Estrutura de Controle Condicional (IF/ELSE)

**Sistema de Autenticação**
- Localização: `Principal.executar()`
- Operador `&&` para verificar login E autenticação
- Controle de tentativas com contador

### 2. Escolha Múltipla com Switch-Case

#### ✅ Menus Implementados:

1. **Menu Principal** (`Principal.exibirMenuPrincipal()`)
   - 5 opções: Cadastros, Consultas, Listagens, Serviços, Sair

2. **Submenu de Cadastros** (`Principal.menuCadastro()`)
   - Cadastro de Cliente ou Funcionário

---

### 3. Laços de Repetição

#### ✅ WHILE

**Uso:** Repetição enquanto condição for verdadeira (número de iterações indefinido)

| Localização | Propósito |
|------------|-----------|
| `Principal.exibirMenuPrincipal()` | Loop principal do sistema |

```java
boolean continuar = true;
while (continuar) {
    // Exibe menu e processa opção
    // continuar = false para sair
}
```

#### ✅ DO-WHILE

**Uso:** Garante execução pelo menos uma vez antes de verificar condição

| Localização | Propósito |
|------------|-----------|
| `Principal.executar()` | Sistema de login com tentativas limitadas |

```java
do {
    System.out.print("Digite a senha: ");
    String senha = scanner.nextLine();
    // validação
} while (!loginSucesso && tentativasLogin < 3);
```

---

### 4. Controle de Fluxo (BREAK e CONTINUE)

#### ✅ BREAK

**Uso:** Interromper execução de loops ou switch

| Localização | Contexto | Efeito |
|------------|----------|--------|
| `Principal.executar()` | Login com 3 tentativas | Encerra loop após máximo de tentativas |
| Todos os `switch-case` | Após cada caso | Evita execução dos próximos casos |
| `ClienteService.buscarPrimeiroPorCPF()` | Busca com `return` | Break implícito ao encontrar |

```java
if (tentativasLogin >= 3) {
    System.out.println("❌ Número máximo de tentativas excedido!");
    break; // Sai do loop de login
}
```

---

## 📁 Estrutura de Pacotes (Atualizada)

```
br.edu.infnet.michellyapi
├── entidades/
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Servico.java
│   └── Agendamento.java
├── service/
│   ├── ClienteService.java
│   ├── FuncionarioService.java
│   ├── ServicoService.java
│   └── AgendamentoService.java
├── principal/
│   └── Principal.java
└── MichellyapiApplication.java
```

---

## 🎯 Funcionalidades Implementadas

### Sistema de Autenticação
- ✅ Login com senha (`admin123`)
- ✅ Máximo de 3 tentativas
- ✅ Controle de acesso com `do-while` e `break`

---

## 🚀 Como Executar

### Requisitos
- **Java 21+**
- **Maven**
- **IDE** (recomendado: IntelliJ IDEA)

---

## 👨‍💻 Autor

**Michelly** - Turma de Fundamentos de Desenvolvimento com Java

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte do curso de Fundamentos de Desenvolvimento com Java.
