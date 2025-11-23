package br.edu.infnet.michellyapi.service;

import java.util.Scanner;

public class AutenticacaoService {
    private int tentativasLogin = 0;
    private boolean usuarioAutenticado = false;
    private Scanner leitura = new Scanner(System.in);


    public boolean autenticar() {
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
            return loginAutorizado;
        } else {
            System.out.println("Acesso não autorizado! Finalizando...");
        }
        return loginAutorizado;
    }
}
