package pe.senati.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable 
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer proveedorId;
	
	@Column
	private String nombre;
	
	@Column
	private Integer telefono;
	

	// en caso de muchos a muchos 
	@ManyToMany(mappedBy="itemsProveedor") //referencia
	private Set<Producto> itemsProducto=new HashSet<>();

	public Proveedor(){
	}

	public Proveedor(Integer proveedorId, String nombre, Integer telefono) {
		this.proveedorId = proveedorId;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Integer getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Set<Producto> getItemsProducto() {
		return itemsProducto;
	}

	public void setItemsProducto(Set<Producto> itemsProducto) {
		this.itemsProducto = itemsProducto;
	} 
	
	
}
