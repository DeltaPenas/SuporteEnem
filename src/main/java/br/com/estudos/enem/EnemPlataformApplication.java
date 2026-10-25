package br.com.estudos.enem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnemPlataformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnemPlataformApplication.class, args);

		System.out.println("DB_USERNAME: " +
				System.getenv("DB_USERNAME"));

		System.out.println("DB_PASSWORD definida: " +
				(System.getenv("DB_PASSWORD") != null));
	}
}