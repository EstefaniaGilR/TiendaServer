package pe.senati.mapper;

public class ProductoProveedorTextMapper {
	
	private String producto;
	private String proveedor;
	
	public ProductoProveedorTextMapper(String producto, String proveedor) {
		this.producto = producto;
		this.proveedor = proveedor;
	}
	
	public ProductoProveedorTextMapper(Object[] object) {
		this(object[0].toString(),
				object[1].toString());
	}

	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	
	

}
