package com.alura.literalura;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		exibirMenu();
	}

	private void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Bem-vindo ao LiterAlura!");
			System.out.println("Selecione uma opção:");
			System.out.println("1. Consultar livro por ID");
			System.out.println("2. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("Digite o ID do livro: ");
					long bookId = scanner.nextLong();
					scanner.nextLine();
					consultarLivroPorId(bookId);
					break;
				case 2:
					System.out.println("Saindo...");
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private void consultarLivroPorId(Long bookId) {
		System.out.println("Função de consulta por ID não implementada ainda.");
	}
}
