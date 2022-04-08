package pe.senati.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.senati.entity.Producto;

//spring data, en automatico tiene save(),deleteById(), findById(),findAll()
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query(value="select * from productos_proveedores order by producto_id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withProveedor();
	
	@Query(value="select prod.nombre as 'producto', prov.nombre as 'proveedor'\r\n"
			+ "from productos_proveedores pp\r\n"
			+ "inner join productos prod on pp.producto_id=prod.producto_id\r\n"
			+ "inner join proveedores prov on pp.proveedor_id=prov.proveedor_id\r\n"
			+ "order by prod.producto_id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withProveedorText();
	
	

}
