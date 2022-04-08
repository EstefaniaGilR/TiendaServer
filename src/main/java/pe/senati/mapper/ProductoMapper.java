package pe.senati.mapper;

import java.time.LocalDate;

import pe.senati.entity.Producto;

public class ProductoMapper {
	
	private String nombre;
	private Double precio;
	private String marca;
	private LocalDate fvencimiento;
	private Integer stock;
	private String categoria;
	
	public ProductoMapper() {
	}
	
	
	public ProductoMapper(String nombre, Double precio, String marca, LocalDate fvencimiento, Integer stock,
			String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.fvencimiento = fvencimiento;
		this.stock = stock;
		this.categoria = categoria;
	}


	public ProductoMapper(Producto producto) {
		this( producto.getNombre(),
				producto.getPrecio(),
				producto.getMarca(),
				producto.getFvencimiento(),
				producto.getStock(),
				producto.getCategoria().getDescripcion()
		);
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Double getPrecio() {
		return precio;
	}




	public void setPrecio(Double precio) {
		this.precio = precio;
	}




	public String getMarca() {
		return marca;
	}




	public void setMarca(String marca) {
		this.marca = marca;
	}




	public LocalDate getFvencimiento() {
		return fvencimiento;
	}




	public void setFvencimiento(LocalDate fvencimiento) {
		this.fvencimiento = fvencimiento;
	}




	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	


	
}
