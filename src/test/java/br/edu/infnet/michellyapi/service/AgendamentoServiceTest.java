package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Agendamento;
import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.entidades.Funcionario;
import br.edu.infnet.michellyapi.entidades.Servico;
import br.edu.infnet.michellyapi.enums.StatusAgendamento;
import br.edu.infnet.michellyapi.enums.TipoServico;
import br.edu.infnet.michellyapi.exceptions.RegraNegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendamentoServiceTest {

    private AgendamentoService agendamentoService;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;

    @BeforeEach
    void setup() {
        agendamentoService = new AgendamentoService();

        cliente = new Cliente("Ana", "12345678900", "21999999999");
        funcionario = new Funcionario("Carlos", "21988888888", "Cabeleireiro", 10);
        servico = new Servico("Corte", "Corte simples", 50.0, TipoServico.CORTE, 30);
    }

    @Test
    void deveAdicionarAgendamento() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        assertEquals(1, agendamentoService.contarAgendamentos());
    }

    @Test
    void deveBuscarPorCliente() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        var lista = agendamentoService.buscarPorCliente(cliente);
        assertEquals(1, lista.size());
        assertEquals(cliente, lista.get(0).getCliente());
    }

    @Test
    void deveBuscarPorStatus() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        var pendentes = agendamentoService.buscarPorStatus(StatusAgendamento.PENDENTE);
        assertEquals(1, pendentes.size());
    }

    @Test
    void deveConfirmarAgendamento() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        boolean resultado = agendamentoService.confirmar(ag.getId());
        assertTrue(resultado);
        assertEquals(StatusAgendamento.CONFIRMADO, ag.getStatus());
    }

    @Test
    void deveLancarExcecaoAoConfirmarIdInexistente() {
        assertThrows(RegraNegocioException.class, () -> {
            agendamentoService.confirmar(999L);
        });
    }

    @Test
    void deveCancelarAgendamento() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        boolean resultado = agendamentoService.cancelar(ag.getId());
        assertTrue(resultado);
        assertEquals(StatusAgendamento.CANCELADO, ag.getStatus());
    }

    @Test
    void deveRetornarFalseAoCancelarIdInexistente() {
        boolean resultado = agendamentoService.cancelar(999L);
        assertFalse(resultado);
    }

    @Test
    void deveContarPorStatus() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        agendamentoService.adicionar(ag);
        agendamentoService.confirmar(ag.getId());
        int confirmados = agendamentoService.contarPorStatus(StatusAgendamento.CONFIRMADO);
        assertEquals(1, confirmados);
    }

    @Test
    void deveBuscarPorData() {
        Agendamento ag = new Agendamento(cliente, funcionario, servico);
        LocalDateTime futura = LocalDateTime.now().plusDays(1);
        ag.setDataHora(futura);
        agendamentoService.adicionar(ag);
        LocalDate dataBusca = futura.toLocalDate();
        List<Agendamento> lista = agendamentoService.buscarPorData(dataBusca);
        assertEquals(1, lista.size());
    }
}