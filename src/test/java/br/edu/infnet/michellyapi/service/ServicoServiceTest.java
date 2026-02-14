package br.edu.infnet.michellyapi.service;

import br.edu.infnet.michellyapi.entidades.Servico;
import br.edu.infnet.michellyapi.enums.TipoServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ServicoServiceTest {
    private ServicoService servicoService;

    @BeforeEach
    void setup() {
        servicoService = new ServicoService();
    }

    @Test
    void deveCadastrarServico() {
        Servico s = new Servico("Corte", "Simples", 50.0, TipoServico.CORTE, 30);
        servicoService.cadastrar(s);
        assertEquals(1, servicoService.contarServicos());
    }

    @Test
    void deveBuscarPorNomeIgnorandoMaiusculas() {
        Servico s = new Servico("Manicure", "Completa", 40.0, TipoServico.MANICURE, 45);
        servicoService.cadastrar(s);
        Servico encontrado = servicoService.buscarPorNome("manicure");
        assertNotNull(encontrado);
        assertEquals("Manicure", encontrado.getNomeServico());
    }

    @Test
    void deveRetornarNullSeNomeNaoExistir() {
        Servico encontrado = servicoService.buscarPorNome("Inexistente");
        assertNull(encontrado);
    }

    @Test
    void deveBuscarPorTipo() {
        Servico s1 = new Servico("Corte", "Simples", 50.0, TipoServico.CORTE, 30);
        Servico s2 = new Servico("Coloração", "Completa", 150.0, TipoServico.COLORACAO, 120);
        servicoService.cadastrar(s1);
        servicoService.cadastrar(s2);
        List<Servico> cortes = servicoService.buscarPorTipo(TipoServico.CORTE);
        assertEquals(1, cortes.size());
        assertEquals(TipoServico.CORTE, cortes.get(0).getTipo());
    }

    @Test
    void deveBuscarPorFaixaPreco() {
        Servico s1 = new Servico("Barato", "Desc", 30.0, TipoServico.CORTE, 20);
        Servico s2 = new Servico("Medio", "Desc", 70.0, TipoServico.CORTE, 40);
        Servico s3 = new Servico("Caro", "Desc", 150.0, TipoServico.CORTE, 60);
        servicoService.cadastrar(s1);
        servicoService.cadastrar(s2);
        servicoService.cadastrar(s3);
        List<Servico> resultado = servicoService.buscarPorFaixaPreco(50.0, 100.0);
        assertEquals(1, resultado.size());
        assertEquals("Medio", resultado.get(0).getNomeServico());
    }

    @Test
    void deveCalcularMediaPrecos() {
        Servico s1 = new Servico("S1", "Desc", 50.0, TipoServico.CORTE, 30);
        Servico s2 = new Servico("S2", "Desc", 150.0, TipoServico.CORTE, 60);
        servicoService.cadastrar(s1);
        servicoService.cadastrar(s2);
        double media = servicoService.calcularMediaPrecos();
        assertEquals(100.0, media);
    }

    @Test
    void deveRetornarZeroSeNaoHouverServicosParaMedia() {
        double media = servicoService.calcularMediaPrecos();
        assertEquals(0.0, media);
    }
}
