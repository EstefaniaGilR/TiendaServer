package pe.senati.mapper;

public class ProductoProveedorMapper {
	
	private Integer productoId;
	private Integer proveedorId;
	
	public ProductoProveedorMapper() {
	}

	public ProductoProveedorMapper(Integer productoId, Integer proveedorId) {
		this.productoId = productoId;
		this.proveedorId = proveedorId;
	}
	
	public ProductoProveedorMapper(Object[] object) {
		this(Integer.parseInt(object[0].toString()),
				Integer.parseInt(object[1].toString()));
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public Integer getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}
	
	

}
