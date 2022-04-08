package pe.senati.service;

import java.util.Collection;

import pe.senati.entity.Producto;

public interface ProductoService {
	
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer productoId);
	public abstract Producto findById(Integer productoId);
	public abstract Collection<Producto> findAll();
	
	public abstract Collection<Object[]> findAll_withProveedor();
	
	public abstract Collection<Object[]> findAll_withProveedorText();
	

}
