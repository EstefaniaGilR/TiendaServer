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

import pe.senati.entity.Jefe;
import pe.senati.mapper.JefeMapper;
import pe.senati.service.JefeService;
import pe.senati.util.UtilMapper;

@RestController
@RequestMapping("/jefe")
public class JefeRestController {
	
	@Autowired
	private JefeService jefeService;


	public JefeRestController() {
	}
	
	@GetMapping("/listar") //con esta url obtengo la direccion listar
	public ResponseEntity<?> Listar()
	{
		Collection<JefeMapper>mapper=UtilMapper.toJefe(jefeService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Jefe jefe){
		jefeService.insert(jefe);
		return new ResponseEntity<>("¡Jefe registrado!",HttpStatus.CREATED);
	}
	
	
	
	//responde con mensajes de errores
	
		@PutMapping("/editar/{jefeId}")
		public ResponseEntity<?> editar(@RequestBody Jefe jefeEdit,@PathVariable Integer jefeId)
		{
			Jefe jefeDb=jefeService.findById(jefeId);
			
			//Verifica la existencia del jefe
			//se edita el jefeEdit, no el jefeDb
			if(jefeDb!=null) {
				jefeDb.setNombre(jefeEdit.getNombre());
				jefeDb.setApellidos(jefeEdit.getApellidos());
				
				jefeService.update(jefeDb);
			return new ResponseEntity<>("¡Jefe actualizando!",HttpStatus.OK);
			}
			
			return new ResponseEntity<>("¡Jefe no existe!",HttpStatus.OK);
		}
		
		
		@DeleteMapping("/borrar/{jefeId}")
		public ResponseEntity<?> borrar(@PathVariable Integer jefeId){
			Jefe jefeDb=jefeService.findById(jefeId);
			
			if(jefeDb!=null) {
				jefeService.delete(jefeId);
				return new ResponseEntity<>("Jefe eliminado",HttpStatus.OK);
			}
			
			return new ResponseEntity<>("Jefe no existe",HttpStatus.NOT_FOUND);
		}
		
		
		@GetMapping("/buscar/{jefeId}")
		public ResponseEntity<?> buscar(@PathVariable Integer jefeId){
			Jefe jefeDb=jefeService.findById(jefeId);
			
			if(jefeDb!=null) {
				JefeMapper mapper=UtilMapper.toJefe(jefeDb);
				return new ResponseEntity<>(mapper,HttpStatus.FOUND);
			}
			return new ResponseEntity<>("¡Jefe no existe!",HttpStatus.NOT_FOUND);
		}
		
		
	
	
}
