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

import pe.senati.entity.Categoria;
import pe.senati.mapper.CategoriaMapper;
import pe.senati.service.CategoriaService;
import pe.senati.util.UtilMapper;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaService categoriaService;

	
	public CategoriaRestController(){
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<CategoriaMapper>mapper=UtilMapper.toCategoria(categoriaService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Categoria categoria)
	{
		categoriaService.insert(categoria);
		return new ResponseEntity<>("Categoria registrada.",HttpStatus.CREATED);
	}
	
	
	@PutMapping("/editar/{categoriaId}")
	public ResponseEntity<?> editar(@RequestBody Categoria categoriaEdit,@PathVariable Integer categoriaId)
	{
		Categoria categoriaDb=categoriaService.findById(categoriaId);
	
		if(categoriaDb!=null)
		{
		categoriaDb.setDescripcion(categoriaEdit.getDescripcion());
		categoriaDb.setJefe(categoriaEdit.getJefe());
	
		categoriaService.update(categoriaDb);
		return new ResponseEntity<>("Categoría actualizada.",HttpStatus.OK);
		}
	
		return new ResponseEntity<>("Categoría no existe.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{categoriaId}")
	public ResponseEntity<?> borrar(@PathVariable Integer categoriaId){
		
		Categoria categoriaDb= categoriaService.findById(categoriaId);
		
		if(categoriaDb!=null) {
			categoriaService.delete(categoriaId);
			return new ResponseEntity<>("Categoría eliminada.",HttpStatus.OK);
		}

		return new ResponseEntity<>("¡Categoría no existe!",HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{categoriaId}")
	public ResponseEntity<?> buscar(@PathVariable Integer categoriaId){
		
		Categoria categoriaDb= categoriaService.findById(categoriaId);
		
		if(categoriaDb!=null) {
			CategoriaMapper mapper=UtilMapper.toCategoria(categoriaDb);
			return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}

		return new ResponseEntity<>("¡Categoría no existe!",HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
