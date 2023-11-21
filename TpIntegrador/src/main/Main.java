package main;
import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Main {
	public static EntityManager getEntityManager(){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		 EntityManager manager = factory.createEntityManager();
		 return manager;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		try {		
			EntityManager emM = getEntityManager();
			emM.getTransaction().begin();
			
			Servicio servicio1 = new Servicio();
			servicio1.setNombre("MariaDb");
			emM.persist(servicio1);
			
			Sector sector = new Sector();
			sector.setNombre("Bases De Datos");
			emM.persist(sector);
			
			MedioDeContacto medio = new MedioDeContacto();
			medio.setNombre("instagram");
			emM.persist(medio);
			
			Tecnico tecnico=new Tecnico();
			tecnico.setNombre("Jesus");
			tecnico.setApellido("Benitez");
			tecnico.setSector(sector);
			tecnico.setMedioDeContacto(medio);
			tecnico.setContacto("jb.6545");
			emM.persist(tecnico);
			Client cl3 = new Client();
			cl3.setNombre("Francisco");
			cl3.setApellido("Grana");
			cl3.setEmail("mail@yahoo.com.ar");
			cl3.setCuil("20-123456-9");
			cl3.setServ(servicio1);
			emM.persist(cl3);
			Incidente incidente = new Incidente();
					incidente.setTiket(123232);
					incidente.setCliente(cl3);
					incidente.setTecnico(tecnico);
					incidente.setHoraestimada(3);
					
					incidente.setHoraDeInicio(LocalDateTime.now());
					incidente.setHoraDeFin(null);
					incidente.setResuelto(false);
					
					emM.persist(incidente);
			
		
			
		emM.getTransaction().commit();
		System.out.println(emM);
		emM.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}	
	}
}
