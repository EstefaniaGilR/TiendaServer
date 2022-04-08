package pe.senati.mapper;

import java.time.LocalDate;

import pe.senati.entity.Jefe;


public class JefeMapper {

	private Integer jefeId;
	private String nombre;
	private String apellidos;
	private LocalDate fcontrato;

	

	public JefeMapper(){
	}




	public JefeMapper(Integer jefeId, String nombre, String apellidos, LocalDate fcontrato) {
		this.jefeId = jefeId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fcontrato = fcontrato;

	}




	public JefeMapper(Jefe jefe) {
		this(jefe.getJefeId(),
				jefe.getNombre(),
				jefe.getApellidos(),
				jefe.getFcontrato());
	}




	public Integer getJefeId() {
		return jefeId;
	}




	public void setJefeId(Integer jefeId) {
		this.jefeId = jefeId;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public LocalDate getFcontrato() {
		return fcontrato;
	}




	public void setFcontrato(LocalDate fcontrato) {
		this.fcontrato = fcontrato;
	}
	
}
