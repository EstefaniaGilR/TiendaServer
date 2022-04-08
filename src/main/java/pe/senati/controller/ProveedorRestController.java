package pe.senati.controller;

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

import pe.senati.entity.Proveedor;
import pe.senati.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {

	@Autowired
	private ProveedorService proveedorService;
	
	public ProveedorRestController() {
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> Listar(){
		return new ResponseEntity<>(proveedorService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("registrar")
		public ResponseEntity<?> registrar(@RequestBody Proveedor proveedor){
			proveedorService.insert(proveedor);
			return new ResponseEntity<>("Proveedor registrado.",HttpStatus.CREATED);
		}
	
	@PutMapping("/editar/{proveedorId}")
	public ResponseEntity<?> editar(@RequestBody Proveedor proveedorEdit, @PathVariable Integer proveedorId)
	{
			Proveedor proveedorDb=proveedorService.findById(proveedorId);
			
			if(proveedorDb!=null) {
				proveedorDb.setNombre(proveedorEdit.getNombre());
				proveedorDb.setTelefono(proveedorEdit.getTelefono());
				
				
				proveedorService.update(proveedorDb);
				return new ResponseEntity<>("Proveedor actualizado",HttpStatus.OK);
			}
			
			return new ResponseEntity<>("Proveedor no exite.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{proveedorId}")
	public ResponseEntity<?> borrar(@PathVariable Integer proveedorId){
		Proveedor proveedorDb=proveedorService.findById(proveedorId);
		
		if(proveedorDb!=null) {
			proveedorService.delete(proveedorId);
			return new ResponseEntity<>("Proveedor eliminado.",HttpStatus.OK);
		}
		return new ResponseEntity<>("Proveedor no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{proveedorId}")
	public ResponseEntity<?> buscar(@PathVariable Integer proveedorId){
		Proveedor proveedorDb=proveedorService.findById(proveedorId);
		
		if(proveedorDb!=null) {
			return new ResponseEntity<>(proveedorDb,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Proveedor no existe.",HttpStatus.NOT_FOUND);
	}
	
	
}
