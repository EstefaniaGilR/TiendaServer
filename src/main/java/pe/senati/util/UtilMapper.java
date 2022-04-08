package pe.senati.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.senati.entity.Categoria;
import pe.senati.entity.Jefe;
import pe.senati.entity.Producto;
import pe.senati.mapper.CategoriaMapper;
import pe.senati.mapper.JefeMapper;
import pe.senati.mapper.ProductoMapper;
import pe.senati.mapper.ProductoProveedorMapper;
import pe.senati.mapper.ProductoProveedorTextMapper;

public class UtilMapper {
	
	public static Collection<CategoriaMapper> toCategoria(Collection<Categoria> collection){
		
		Collection<CategoriaMapper> mapper=new ArrayList<>();
		
		for(Categoria categoria:collection) {
			CategoriaMapper categoriaMapper=new CategoriaMapper(categoria);
			mapper.add(categoriaMapper);
		}
		
		return mapper;
	}
	
	public static CategoriaMapper toCategoria(Categoria categoria) {
		CategoriaMapper mapper=new CategoriaMapper(categoria);
		return mapper;
	}
	

	
	public static Collection<JefeMapper> toJefe(Collection<Jefe> collection)
	{
		Collection<JefeMapper> mapper=new ArrayList<>();
		
		for(Jefe jefe:collection) {
			JefeMapper jefeMapper=new JefeMapper(jefe);
			mapper.add(jefeMapper);
		}
		
		return mapper;
		
	}
	
	public static JefeMapper toJefe(Jefe jefe)
	{
		JefeMapper mapper=new JefeMapper(jefe);
		return mapper;
	}
	
	
	public static Collection<ProductoMapper> toProducto(Collection<Producto> collection)
	{
		Collection<ProductoMapper> mapper=new ArrayList<>();
		
		for(Producto producto:collection) {
			ProductoMapper productoMapper=new ProductoMapper(producto);
			mapper.add(productoMapper);
		}
		
		return mapper;
		
	}
	
	public static ProductoMapper toProducto(Producto producto)
	{
		ProductoMapper mapper=new ProductoMapper(producto);
		return mapper;
	}
	
	
	
	public static Collection<ProductoProveedorMapper> toProductoProveedor(Collection<Object[]> collection)
	{
		Collection<ProductoProveedorMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			ProductoProveedorMapper productoProveedorMapper=new ProductoProveedorMapper(object);
			mapper.add(productoProveedorMapper);
		}
		
		return mapper;
		
	}
	
	public static Collection<ProductoProveedorTextMapper> toProductoProveedorText(Collection<Object[]> collection)
	{
		Collection<ProductoProveedorTextMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			ProductoProveedorTextMapper productoProveedorTextMapper=new ProductoProveedorTextMapper(object);
			mapper.add(productoProveedorTextMapper);
		}
		
		return mapper;
		
	}
	
	
}
