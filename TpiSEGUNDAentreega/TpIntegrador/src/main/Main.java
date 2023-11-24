package main;
import java.time.LocalDateTime;

import entidades.Client;
import entidades.Incidente;
import entidades.MedioDeContacto;
import entidades.Sector;
import entidades.Servicio;
import entidades.Tecnico;
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
			
			
			Servicio serv = new Servicio();
			serv.setNombre("MariaDb");
			
			
			Servicio servicio2 = new Servicio();
			servicio2.setNombre("Tango");
			
			
			Servicio servicio3 = new Servicio();
			servicio3.setNombre("Apple");
		
		
			Sector sector = new Sector();
			sector.setNombre("Web");
				
			Sector sector2 = new Sector();
			sector2.setNombre("Bases De Datos");
			
			
			
			MedioDeContacto medio = new MedioDeContacto();
			medio.setNombre("instagram");
			
			MedioDeContacto medio2 = new MedioDeContacto();
			medio2.setNombre("Telegram");
			
			
			
			
			Tecnico tecnico2=new Tecnico();
			tecnico2.setNombre("Jose");
			tecnico2.setApellido("Juan");
			tecnico2.setSector(sector2);
			tecnico2.setMedioDeContacto(medio2);
			tecnico2.setContacto("jj3409");
			
			Tecnico tecnico=new Tecnico();
			tecnico.setNombre("Jesus");
			tecnico.setApellido("Benitez");
			tecnico.setSector(sector);
			tecnico.setMedioDeContacto(medio);
			tecnico.setContacto("jb.6545");
			
			
			Client cl3 = new Client();
			cl3.setNombre("Francisco");
			cl3.setApellido("Grana");
			cl3.setEmail("mail@yahoo.com.ar");
			cl3.setCuil("20-123456-9");
			cl3.setServ(serv);
			
			
			Client cl2 = new Client();
			cl2.setNombre("Alfredo");
			cl2.setApellido("Gómez");
			cl2.setEmail("mail2@ciudad.com.ar");
			cl2.setCuil("20-654321-9");
			cl2.setServ(servicio2);
			
			
			Client cl = new Client();
			cl.setNombre("Ludmila");
			cl.setApellido("Juan");
			cl.setEmail("mail2@online.com.ar");
			cl.setCuil("20-654331-9");
			cl.setServ(servicio3);
			
			
			
			Incidente incidente = new Incidente();
					incidente.setTiket(123232);
					incidente.setCliente(cl3);
					incidente.setTecnico(tecnico);
					incidente.setHoraestimada(3);
					incidente.setHoraDeInicio(LocalDateTime.now());
					incidente.setHoraDeFin(LocalDateTime.now().plusHours(2));
					incidente.setTiempoTrascurrido(3);
					incidente.setServicio(servicio3);
					
					
							
					Incidente incidente2 = new Incidente();
					incidente2.setTiket(123232);
					incidente2.setCliente(cl3);
					incidente2.setTecnico(tecnico2);
					incidente2.setHoraestimada(2);
					incidente2.setHoraDeInicio(LocalDateTime.now());
					incidente2.setHoraDeFin(LocalDateTime.now().plusHours(2));
					incidente2.setTiempoTrascurrido(2);
					incidente2.setServicio(servicio2);
					
					
		
					Incidente incidente3 = new Incidente();
					incidente3.setTiket(123233);
					incidente3.setCliente(cl2);
					incidente3.setTecnico(tecnico);
					incidente3.setHoraestimada(0);
					incidente3.setHoraDeInicio(LocalDateTime.now());
					incidente3.setHoraDeFin(LocalDateTime.now().plusHours(4));
					incidente3.setTiempoTrascurrido(4);
					incidente3.setServicio(serv);
		
					
					emM.persist(medio);
					emM.persist(medio2);
					
					emM.persist(sector2);
					emM.persist(sector);
					
					emM.persist(serv);
					emM.persist(servicio2);
					emM.persist(servicio3);
					
				    emM.persist(tecnico);
					emM.persist(tecnico2);
					
					
					
					emM.persist(cl2);
				   emM.persist(cl3);
					emM.persist(cl);
					
					emM.persist(incidente3);
					emM.persist(incidente2);
					emM.persist(incidente);
			
		
			//emM.clear();
		emM.getTransaction().commit();
		System.out.println(emM);
		emM.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}	
	}
}
