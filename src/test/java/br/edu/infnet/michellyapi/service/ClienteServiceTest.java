package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.exceptions.RegraNegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {
    private ClienteService clienteService;

    @BeforeEach
    void setup() {
        clienteService = new ClienteService();
    }

    @Test
    void deveCadastrarClienteComSucesso() {
        Cliente cliente = new Cliente("Ana", "11111111111", "21999999999");
        clienteService.cadastrar(cliente);
        assertEquals(1, clienteService.contarClientes());
    }

    @Test
    void naoDevePermitirCpfDuplicado() {
        Cliente cliente = new Cliente("Ana", "22222222222", "21999999999");
        clienteService.cadastrar(cliente);
        assertThrows(RegraNegocioException.class, () -> {
            clienteService.cadastrar(cliente);
        });
    }

    @Test
    void deveBuscarClientePorCpf() {
        Cliente cliente = new Cliente("Maria", "33333333333", "21988888888");
        clienteService.cadastrar(cliente);
        Cliente encontrado = clienteService.buscarPorCpf("33333333333");
        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNomeCliente());
    }

    @Test
    void deveRetornarNullSeCpfNaoExistir() {
        Cliente encontrado = clienteService.buscarPorCpf("00000000000");
        assertNull(encontrado);
    }

    @Test
    void deveBuscarPorNomeIgnorandoMaiusculas() {
        Cliente cliente = new Cliente("Carlos", "44444444444", "21977777777");
        clienteService.cadastrar(cliente);
        Cliente encontrado = clienteService.buscarPorNome("carlos");
        assertNotNull(encontrado);
    }

    @Test
    void deveBuscarPorNomeParcial() {
        Cliente c1 = new Cliente("Fernanda Silva", "55555555555", "21966666666");
        Cliente c2 = new Cliente("Fernando Souza", "66666666666", "21955555555");
        clienteService.cadastrar(c1);
        clienteService.cadastrar(c2);
        List<Cliente> resultado = clienteService.buscarPorNomeParcial("fern");
        assertEquals(2, resultado.size());
    }

    @Test
    void deveRetornarTrueSeClienteExistir() {
        Cliente cliente = new Cliente("Joao", "77777777777", "21944444444");
        clienteService.cadastrar(cliente);
        assertTrue(clienteService.existeClienteComCpf("77777777777"));
    }

    @Test
    void deveRetornarFalseSeClienteNaoExistir() {
        assertFalse(clienteService.existeClienteComCpf("99999999999"));
    }

    @Test
    void deveListarClientesFidelizados() {
        Cliente c1 = new Cliente("Cliente A", "88888888888", "21933333333");
        Cliente c2 = new Cliente("Cliente B", "99999999999", "21922222222");
        clienteService.cadastrar(c1);
        clienteService.cadastrar(c2);
        List<Cliente> fidelizados = clienteService.listarClientesFidelizados();
        assertNotNull(fidelizados);
    }
}
