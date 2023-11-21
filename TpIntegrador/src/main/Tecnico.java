package main;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="tecnico")
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name="medioDeContacto")
	private MedioDeContacto medioDeContacto;
	
	@Column(name="contacto")
	private String contacto;
	
	
	@ManyToOne
	@JoinColumn(name="sector")
	private Sector sector;
	
	
	
	
	public Tecnico() {
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public MedioDeContacto getMedioDeContacto() {
		return medioDeContacto;
	}




	public void setMedioDeContacto(MedioDeContacto medioDeContacto) {
		this.medioDeContacto = medioDeContacto;
	}




	public String getContacto() {
		return contacto;
	}




	public void setContacto(String contacto) {
		this.contacto = contacto;
	}




	public Sector getSector() {
		return sector;
	}




	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	
	
	
}
