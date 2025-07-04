/*package org.bedu.inventario;

import jakarta.persistence.*;
import jakarta.persistence.Id; // ✅ La correcta para JPA


@Entity
public class Producto {

	@Id // Campo que funcionará como clave primaria de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
	private Long id;

	// Campos que serán columnas en la tabla 'producto'
	private String nombre;
	private String descripcion;
	private double precio;
	@ManyToOne
	@JoinColumn(name = "categoria_id") // nombre de la columna FK en la tabla productos
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	protected Producto() {} // Constructor por defecto requerido por JPA

	// Constructor público para crear objetos de tipo Producto con los campos necesarios
	/*
	public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}*/
/*
	public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}
	public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.marca = marca;
	}

	// Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
	public Long getId() { return id; }
	public String getNombre() { return nombre; }
	public String getDescripcion() { return descripcion; }
	public double getPrecio() { return precio; }

	public Categoria getCategoria() {
		return categoria;
	}
	public Marca getMarca() {
		return marca;
	}

	// Metodo que permite imprimir el objeto de forma legible (útil para logs o consola)
		@Override
		/*
		public String toString() {
			return String.format(
					"Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s']",
					id, nombre, precio, categoria != null ? categoria.getNombre() : "Sin categoría"
			);
		public String toString() {
			return String.format("Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s', marca='%s']",
					id, nombre, precio,
					categoria != null ? categoria.getNombre() : "Sin categoría",
					marca != null ? marca.getNombre() : "Sin marca");
		}
		}
	}*/
package org.bedu.inventario;

import jakarta.persistence.*;
import org.bedu.inventario.Categoria;
import org.bedu.inventario.Marca;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String descripcion;
	private double precio;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	protected Producto() {
	}

	public Producto(String nombre, String descripcion, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return String.format("Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s', marca='%s']",
				id, nombre, precio,
				categoria != null ? categoria.getNombre() : "Sin categoría",
				marca != null ? marca.getNombre() : "Sin marca");
	}
}


