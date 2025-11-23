package br.edu.infnet.michellyapi;

import br.edu.infnet.michellyapi.principal.Principal;
import br.edu.infnet.michellyapi.testes.ClasseParaTestes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MichellyapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MichellyapiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

        ClasseParaTestes.executarTestes();

		Principal principal = new Principal();
		principal.executar();
	}
}
