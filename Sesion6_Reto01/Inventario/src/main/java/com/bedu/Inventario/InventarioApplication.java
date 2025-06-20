package com.bedu.Inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InventarioApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(com.bedu.inventario.ProductoRepository repository) {
		return args -> {
			repository.save(new com.bedu.inventario.Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new com.bedu.inventario.Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new com.bedu.inventario.Producto("Mouse gamer", "Alta precisión", 600.00));

			System.out.println("📂 Productos disponibles:");
			repository.findAll().forEach(System.out::println);

			System.out.println("\n🔍 Productos que contienen 'Lap':");
			repository.findByNombreContaining("Lap").forEach(System.out::println);

			// 👇 Cierra la app una vez terminado
			System.exit(0);
		};
	}

}
