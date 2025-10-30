package com.docencia.dam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.docencia.dam.controllers.CliController;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(CliController procesos) {
		return args -> {
			System.out.println("Iniciando proceso al arrancar la aplicación...");

			procesos.menuConsola();

			System.out.println("Proceso finalizado.");
		};
	}

}
