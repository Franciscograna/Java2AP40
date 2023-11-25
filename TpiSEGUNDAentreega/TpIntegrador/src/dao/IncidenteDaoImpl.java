package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Incidente;
import entidades.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class IncidenteDaoImpl implements IncidenteDao {

	private EntityManager em;

	
	
	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
		
	}


	
	public Tecnico obtenerTecnicoPorId(int id) {
        return em.find(Tecnico.class, id);
    }

	    public Incidente obtenerIncidentePorId(int id) {
	        return em.find(Incidente.class, id);
	    }

	
	
	
	@Override
    public void guardarIncidente(Incidente incidente) {
        em.getTransaction().begin();
        em.persist(incidente);
        em.getTransaction().commit();
    }

	
	@Override
    public void editarIncidente(Incidente incidente) {
		 em.getTransaction().begin();
        em.merge(incidente);
        em.getTransaction().commit();
    }

	
	
	@Override
	public void editarTecnico(Tecnico tecnico) {
		//em.getTransaction().begin();
	    em.merge(tecnico);
        em.getTransaction().commit();
    
		
	}
	
	
	@Override
	public Tecnico obtenerTrabajadorConMasIncidentes() {
	    String jpql = "SELECT i.tecnico, COUNT(i) FROM Incidente i GROUP BY i.tecnico ORDER BY COUNT(i) DESC";
	    Query query = em.createQuery(jpql, Object[].class);
	    query.setMaxResults(1); 
//obtener los técnicos con el máximo valor de incidentes
	    List<Object[]> resultados = query.getResultList();
//guardarlos en lista
	    if (!resultados.isEmpty()) {
//manejo excepcion
	        Long maxIncidentes = (Long) resultados.get(0)[1]
//guardar el valor máximo
	        int i =0;
	        List<Tecnico> trabajadoresConMaxIncidentes = new ArrayList<>();
	        for (Object[] resultado : resultados) {
	            Long incidentes = (Long) resultado[1];
	            if (incidentes.equals(maxIncidentes)) {
	                trabajadoresConMaxIncidentes.add((Tecnico) resultado[0]);
	 
//guardo los técnicos con más incidentes en una lista             
	                i++;
	            } else {
	                break; 
	            }
	        }
	        int j=0; 
	        while ( j<i) {System.out.println(trabajadoresConMaxIncidentes.get(j).getNombre());j++;}
	       
	        return trabajadoresConMaxIncidentes.get(0);
	    }

	    return null; 
	}

	
	public List<Incidente> obtenerIncidentesPorTecnico(Tecnico tecnico) {
		
	    String jpql = "SELECT i FROM Incidente i WHERE i.tecnico = :tecnico";
	    Query query = em.createQuery(jpql, Incidente.class);
	    query.setParameter("tecnico", tecnico);

	    return query.getResultList();
	}

	
	
	
	

	
	
}
