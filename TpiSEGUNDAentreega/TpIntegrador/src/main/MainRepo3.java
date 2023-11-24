package main;

import dao.DaoFactory;
import dao.IncidenteDao;
import entidades.Incidente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRepo3 {
	
	public static EntityManager getEntityManager(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		 EntityManager manager = factory.createEntityManager();
		 return manager;
	}

	public static void main(String[] args) {


		EntityManager emM = getEntityManager();
		emM.getTransaction().begin();
		Incidente incidente = new Incidente();
		
		
		 IncidenteDao incidenteDAO = DaoFactory.geIncidenteDAO();
	     incidenteDAO.setEntityManager(emM);
	        /*
	        Tecnico tecnicoConMasIncidentes = incidenteDAO.obtenerTrabajadorConMasIncidentes();
	        
	        if (tecnicoConMasIncidentes != null) {;       } else {
	            System.out.println("No se encontró un técnico con incidentes");
	        }

	        Tecnico tecnico1 = new Tecnico();
	         tecnico1 = incidenteDAO.obtenerTecnicoPorId(2);
	         tecnico1 = incidenteDAO.obtenerTecnicoPorId(2);
	         */
	        Incidente inc2 = new Incidente();
	         inc2 = incidenteDAO.obtenerIncidentePorId(1);
	         
	         incidenteDAO.editarIncidente(inc2);
	      
	         //System.out.println(tecnico1.getNombre()+ " "+tecnico1.getContacto());
	         //System.out.println(inc2.getCliente().getCuil());
	         //System.out.println( incidenteDAO.obtenerIncidentesPorTecnico(tecnico1));
	         
	         //inc2.accion();
	         
	         //EstadoAccion estado = null;
	         //inc2.setEstado(estado.RESOLVIENDOSE);
	         //incidenteDAO.editarIncidente(inc2);
	         
	         //tecnico1.setContacto("juanjuan32");
	         
	         //incidenteDAO.editarTecnico(tecnico1);
	         //System.out.println(tecnico1.getNombre()+ " "+tecnico1.getContacto());
	         
	         
	         inc2.accion();
	        emM.close();

		
	}

}
