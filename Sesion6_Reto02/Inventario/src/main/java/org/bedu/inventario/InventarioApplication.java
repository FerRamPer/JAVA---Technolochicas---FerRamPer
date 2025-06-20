/*ackage org.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);

	}
	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo) {
		return (args) -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			productoRepo.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia));
			productoRepo.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia));
			productoRepo.save(new Producto("Tablet Lenovo", "Pantalla 10 pulgadas", 7800.00, tecnologia));

			System.out.println("📂 Productos registrados:");
			productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getCategoria().getNombre()));
		};
	}
}*/
package org.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}
/*NOTAS
CommandLineRunner es una interfaz especial de Spring Boot que permite ejecutar código justo
después de que la aplicación ha arrancado completamente. Sirve para:
- Insertar datos de prueba en la base de datos sin necesidad de interfaz gráfica o Postman
- Ejecutar pruebas rápidas de lógica
- Configurar valores iniciales
- Mostrar mensajes en consola
- Consumir servicios o APIs al arranque

 */
	@Bean
	public CommandLineRunner demo(
			ProductoRepository productoRepo,
			CategoriaRepository categoriaRepo,
			MarcaRepository marcaRepo
	) {
		return (args) -> {
			// Crear categoría
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			// Crear marcas
			Marca apple = new Marca("Apple");
			Marca samsung = new Marca("Samsung");
			marcaRepo.save(apple);
			marcaRepo.save(samsung);

			// Crear productos y asociarlos a categorías y marcas
			productoRepo.save(new Producto("iPhone 15", "Smartphone de gama alta", 25000.00, tecnologia, apple));
			productoRepo.save(new Producto("iPad Pro", "Tablet profesional", 30000.00, tecnologia, apple));
			productoRepo.save(new Producto("Galaxy S23", "Smartphone premium", 24000.00, tecnologia, samsung));
			productoRepo.save(new Producto("Smart TV", "Pantalla 65 pulgadas", 18000.00, tecnologia, samsung));

			// Mostrar productos agrupados por marca
			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
		};
	}
}


