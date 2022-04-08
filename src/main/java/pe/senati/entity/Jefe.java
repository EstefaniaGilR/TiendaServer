package pe.senati.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="jefes")
public class Jefe implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jefeId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fcontrato;
	
	@OneToOne(mappedBy="jefe") //referencia
	private Categoria categoria;

	public Jefe(){
	}

	public Jefe(Integer jefeId, String nombre, String apellidos, LocalDate fcontrato) {
		this.jefeId = jefeId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fcontrato = fcontrato;
	}
	
	// la fecha de contrato ya se tiene antes de insertar un jefe a la bd
	@PrePersist
	public void prePersist() {
		fcontrato=LocalDate.now();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
