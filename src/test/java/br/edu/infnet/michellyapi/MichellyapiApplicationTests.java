package br.edu.infnet.michellyapi;

import br.edu.infnet.michellyapi.entidades.Cliente;
import br.edu.infnet.michellyapi.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MichellyapiApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void testCadastrarCliente() {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente("Cliente Teste", "12345678910", "21987654321");
    }

}
