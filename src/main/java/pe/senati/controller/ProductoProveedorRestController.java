package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.senati.entity.Producto;
import pe.senati.entity.ProductoProveedor;
import pe.senati.entity.Proveedor;
import pe.senati.mapper.ProductoProveedorMapper;
import pe.senati.mapper.ProductoProveedorTextMapper;
import pe.senati.service.ProductoService;
import pe.senati.service.ProveedorService;
import pe.senati.util.UtilMapper;

@RestController
@RequestMapping("/producto_proveedor")
public class ProductoProveedorRestController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	
	public ProductoProveedorRestController (){
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<ProductoProveedorMapper> mapper=
				UtilMapper.toProductoProveedor(productoService.findAll_withProveedor());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@GetMapping("/listar_text")
	public ResponseEntity<?> listarText_GET(){
		Collection<ProductoProveedorTextMapper> mapper=
				UtilMapper.toProductoProveedorText(productoService.findAll_withProveedorText());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	
	@PutMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody ProductoProveedor productoProveedor){
		Producto productoDb = productoService.findById(productoProveedor.getProducto().getProductoId());
		
		if(productoDb!=null) {
			Proveedor proveedorDb=proveedorService.findById(productoProveedor.getProveedor().getProveedorId());
			if(proveedorDb!=null) {
				
				productoDb.addProveedor(proveedorDb);
				productoService.insert(productoDb);
				
				return new ResponseEntity<>("Producto proveedor registrado.",HttpStatus.CREATED);
			}
			
			return new ResponseEntity<>("Proveedor no existe.",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Producto proveedor no existe.",HttpStatus.NOT_FOUND);
	}
	

}
