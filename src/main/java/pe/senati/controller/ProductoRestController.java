package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.senati.entity.Producto;
import pe.senati.mapper.ProductoMapper;
import pe.senati.service.ProductoService;
import pe.senati.util.UtilMapper;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	public ProductoRestController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<ProductoMapper>mapper=UtilMapper.toProducto(productoService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Producto producto) {
		productoService.insert(producto);
		return new ResponseEntity<>("Producto registrado.",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{productoId}")
	public ResponseEntity<?> editar(@RequestBody Producto productoEdit,@PathVariable Integer productoId)
	{
	Producto productoDb=productoService.findById(productoId);

	if(productoDb!=null)
	{
		productoDb.setNombre(productoEdit.getNombre());
		productoDb.setPrecio(productoEdit.getPrecio());
		productoDb.setMarca(productoEdit.getMarca());
		productoDb.setFvencimiento(productoEdit.getFvencimiento());
		productoDb.setStock(productoEdit.getStock());
		productoDb.setCategoria(productoEdit.getCategoria());

		productoService.update(productoDb);
		return new ResponseEntity<>("Producto actualizado",HttpStatus.OK);
		}

	return new ResponseEntity<>("Producto no existe",HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/borrar/{productoId}")
	public ResponseEntity<?> borrar(@PathVariable Integer productoId){
		Producto productoDb = productoService.findById(productoId);
		
		if(productoDb!=null) {
			productoService.delete(productoId);
			return new ResponseEntity<>("Producto eliminado.",HttpStatus.OK);
		}
		return new ResponseEntity<>("No existe el producto.",HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{productoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId){
		Producto productoDb = productoService.findById(productoId);
		
		if(productoDb!=null) {
			ProductoMapper mapper=UtilMapper.toProducto(productoDb);
			return new ResponseEntity<>(mapper,HttpStatus.OK);
		}
		return new ResponseEntity<>("No existe el producto.",HttpStatus.OK);
	}
}


