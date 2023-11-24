package main;

import dao.DaoFactory;
import dao.IncidenteDao;
import entidades.Incidente;
import entidades.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRepo2 {

	public static EntityManager getEntityManager(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		 EntityManager manager = factory.createEntityManager();
		 return manager;
	}
	public static void main(String[] args) {
		EntityManager emM = getEntityManager();
		emM.getTransaction().begin();
		IncidenteDao incidenteDAO = DaoFactory.geIncidenteDAO();
	    incidenteDAO.setEntityManager(emM);
		Tecnico tecnico1 = new Tecnico();
        tecnico1 = incidenteDAO.obtenerTecnicoPorId(2);
        System.out.println("Obtengo tecnico por id, observar contacto");
        System.out.println(tecnico1.getNombre()+" "+tecnico1.getApellido()+" "+tecnico1.getContacto());
        System.out.println("Obtengo incidentes de este tecnico");
        for (int i=0;i<incidenteDAO.obtenerIncidentesPorTecnico(tecnico1).size();i++)
        {System.out.println( incidenteDAO.obtenerIncidentesPorTecnico(tecnico1).get(i).getServicio().getNombre());}
        System.out.println("Actcualizo su info de contacto");
        tecnico1.setContacto("micontactonuevo3434");
        incidenteDAO.editarTecnico(tecnico1);
        Tecnico tecnico11 = new Tecnico();
        tecnico11 = incidenteDAO.obtenerTecnicoPorId(2);
        System.out.println(tecnico11.getNombre()+" "+tecnico11.getApellido()+" "+tecnico11.getContacto());
        System.out.println("Obtengo tecnico con mas incidentes");
	     incidenteDAO.setEntityManager(emM);
	     Tecnico tecnicoConMasIncidentes = incidenteDAO.obtenerTrabajadorConMasIncidentes();
	     if (tecnicoConMasIncidentes != null) {;       } else {
	            System.out.println("No se encontró un técnico con incidentes");
	     }
	     System.out.println(tecnicoConMasIncidentes);
	     emM.close();
	}

}
