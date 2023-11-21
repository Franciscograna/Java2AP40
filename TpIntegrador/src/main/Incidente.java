package main;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="incidente")
public class Incidente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="tiket")
	private int tiket;
	@ManyToOne
	@JoinColumn(name="cliente")
	private Client cliente;
	@ManyToOne
	@JoinColumn(name="servicio")
	private Servicio servicio;
	public int getHoraestimada() {
		return horaestimada;
	}

	public void setHoraestimada(int horaestimada) {
		this.horaestimada = horaestimada;
	}

	@ManyToOne
	@JoinColumn(name="tecnico")
	private Tecnico tecnico;
	
	
	@Column(name="resuelto")
	private boolean resuelto;
	@Column(name="inicio")
	private LocalDateTime horaDeInicio;
	@Column(name="fin")
	private LocalDateTime horaDeFin;
	
	@Column(name="horaestimada")
	private int horaestimada;
	
	
	
	public Incidente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTiket() {
		return tiket;
	}

	public void setTiket(int tiket) {
		this.tiket = tiket;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	
	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

	public LocalDateTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(LocalDateTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}

	public LocalDateTime getHoraDeFin() {
		return horaDeFin;
	}

	public void setHoraDeFin(LocalDateTime horaDeFin) {
		this.horaDeFin = horaDeFin;
	}
	
	
	

}
