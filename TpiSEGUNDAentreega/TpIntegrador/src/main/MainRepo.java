package main;
import java.util.List;

import dao.DaoFactory;
import dao.IncidenteDao;
import entidades.Incidente;
import entidades.Servicio;
import entidades.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import state.EstadoAccion;

public class MainRepo {
	public static EntityManager getEntityManager(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		 EntityManager manager = factory.createEntityManager();
		 return manager;
	}
	public static void main(String[] args) {		
		 EntityManager emM = getEntityManager();
		 Incidente incidente = new Incidente();
		 IncidenteDao incidenteDAO = DaoFactory.geIncidenteDAO();
	     incidenteDAO.setEntityManager(emM);
	     Incidente inc2 = new Incidente();
         inc2 = incidenteDAO.obtenerIncidentePorId(1);
         System.out.println("incidente:"+inc2.getTiket()+" "+inc2.getServicio().getNombre());  
         System.out.println("primera accion segun su estado inicial");
         inc2.accion();     
         EstadoAccion estado = null;
         inc2.setEstado(estado.RESUELTO);
         incidenteDAO.editarIncidente(inc2);
         System.out.println("segunda accion segun su estado actual");
         inc2.accion();	
         
	}
}
