package dao;

import java.util.List;

import entidades.Incidente;
import entidades.Tecnico;
import jakarta.persistence.EntityManager;

public interface IncidenteDao {

	void guardarIncidente(Incidente incidente);

	List<Incidente> obtenerIncidentesPorTecnico(Tecnico tecnico );
	
    Tecnico obtenerTrabajadorConMasIncidentes();

    public void setEntityManager(EntityManager em);

	Incidente obtenerIncidentePorId(int id);

	Tecnico obtenerTecnicoPorId(int id);  //separar dao?

	void editarIncidente(Incidente incidente);
	
	void editarTecnico(Tecnico tecnico);
	
	
}
