package pe.senati.mapper;

import pe.senati.entity.Categoria;

public class CategoriaMapper {

	private Integer categoriaId;
	private String descripcion;
	private Integer jefeId;
	
	public CategoriaMapper(){
	}

	public CategoriaMapper(Integer categoriaId, String descripcion, Integer jefeId) {
		this.categoriaId = categoriaId;
		this.descripcion = descripcion;
		this.jefeId = jefeId;
	}
	
	public CategoriaMapper(Categoria categoria) {
		this(categoria.getCategoriaId(),
				categoria.getDescripcion(),
				categoria.getJefe().getJefeId());
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getJefeId() {
		return jefeId;
	}

	public void setJefeId(Integer jefeId) {
		this.jefeId = jefeId;
	}
	
	
}