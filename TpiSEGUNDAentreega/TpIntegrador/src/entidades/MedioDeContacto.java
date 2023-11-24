package entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="mediodecontacto")
public class MedioDeContacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="nombre")
private String nombre;

public MedioDeContacto() {
	
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




}
