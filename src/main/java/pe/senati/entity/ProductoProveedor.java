package pe.senati.entity;

public class ProductoProveedor {

	private Producto producto;
	private Proveedor proveedor;
	
	public ProductoProveedor(Producto producto, Proveedor proveedor) {
		this.producto = producto;
		this.proveedor = proveedor;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
}
