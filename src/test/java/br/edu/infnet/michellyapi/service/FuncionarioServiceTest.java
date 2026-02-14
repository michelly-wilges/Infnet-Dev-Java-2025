package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {
    private FuncionarioService funcionarioService;

    @BeforeEach
    void setup() {
        funcionarioService = new FuncionarioService();
    }

    @Test
    void deveCadastrarFuncionario() {
        Funcionario f = new Funcionario("Ana", "21999999999", "Cabeleireira", 10);
        funcionarioService.cadastrar(f);
        assertEquals(1, funcionarioService.contarFuncionarios());
    }

    @Test
    void deveBuscarPorNomeIgnorandoMaiusculas() {
        Funcionario f = new Funcionario("Carlos", "21988888888", "Barbeiro", 15);
        funcionarioService.cadastrar(f);
        Funcionario encontrado = funcionarioService.buscarPorNome("carlos");
        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNomeFuncionario());
    }

    @Test
    void deveRetornarNullSeNomeNaoExistir() {
        Funcionario encontrado = funcionarioService.buscarPorNome("Inexistente");
        assertNull(encontrado);
    }

    @Test
    void deveBuscarPorNomeParcial() {
        Funcionario f1 = new Funcionario("Fernanda", "1", "Manicure", 10);
        Funcionario f2 = new Funcionario("Fernando", "2", "Barbeiro", 15);
        funcionarioService.cadastrar(f1);
        funcionarioService.cadastrar(f2);
        List<Funcionario> resultado = funcionarioService.buscarPorNomeParcial("fern");
        assertEquals(2, resultado.size());
    }

    @Test
    void deveBuscarPorCargo() {
        Funcionario f1 = new Funcionario("Ana", "1", "Cabeleireira", 10);
        Funcionario f2 = new Funcionario("Bruno", "2", "Manicure", 15);
        funcionarioService.cadastrar(f1);
        funcionarioService.cadastrar(f2);
        List<Funcionario> resultado = funcionarioService.buscarPorCargo("cabeleireira");
        assertEquals(1, resultado.size());
        assertEquals("Ana", resultado.get(0).getNomeFuncionario());
    }

    @Test
    void deveListarTodos() {
        funcionarioService.cadastrar(new Funcionario("A", "1", "X", 10));
        funcionarioService.cadastrar(new Funcionario("B", "2", "Y", 15));
        List<Funcionario> lista = funcionarioService.listarTodos();
        assertEquals(2, lista.size());
    }
}
