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
		//em.getTransaction().begin();
	    String jpql = "SELECT i.tecnico, COUNT(i) FROM Incidente i GROUP BY i.tecnico ORDER BY COUNT(i) DESC";
	    Query query = em.createQuery(jpql, Object[].class);
	    query.setMaxResults(1); 
	    
	    List<Object[]> resultados = query.getResultList();

	    if (!resultados.isEmpty()) {
	    	
	        Long maxIncidentes = (Long) resultados.get(0)[1];
	        int i =0;
	        List<Tecnico> trabajadoresConMaxIncidentes = new ArrayList<>();
	        for (Object[] resultado : resultados) {
	            Long incidentes = (Long) resultado[1];
	            if (incidentes.equals(maxIncidentes)) {
	            	
	                trabajadoresConMaxIncidentes.add((Tecnico) resultado[0]);
	                
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
		//em.getTransaction().begin();
	    String jpql = "SELECT i FROM Incidente i WHERE i.tecnico = :tecnico";
	    Query query = em.createQuery(jpql, Incidente.class);
	    query.setParameter("tecnico", tecnico);

	    return query.getResultList();
	}

	
	
	/*
	@Override
	public Tecnico obtenerTrabajadorConMasIncidentes() {
	    String jpql = "SELECT i.tecnico, COUNT(i), SUM(i.tiempoTrascurrido) FROM Incidente i GROUP BY i.tecnico ORDER BY COUNT(i) DESC";
	    Query query = em.createQuery(jpql, Object[].class);
	    query.setMaxResults(1);

	    List<Object[]> resultados = query.getResultList();

	    if (!resultados.isEmpty()) {

	        Long maxIncidentes = (Long) resultados.get(0)[1];
	        double menorPromedio = Double.MAX_VALUE;
	        List<Tecnico> trabajadoresConMenorPromedio = new ArrayList<>();

	        for (Object[] resultado : resultados) {
	            Long incidentes = (Long) resultado[1];
	            double tiempoTrascurrido = (Double) resultado[2];
	            double promedio = tiempoTrascurrido / incidentes;

	            if (incidentes.equals(maxIncidentes) && (promedio < menorPromedio)) {
	              //  trabajadoresConMenorPromedio.clear();
	                trabajadoresConMenorPromedio.add((Tecnico) resultado[0]);
	                menorPromedio = promedio;
	            } else if (incidentes.equals(maxIncidentes) && promedio == menorPromedio) {
	                trabajadoresConMenorPromedio.add((Tecnico) resultado[0]);
	            } else {
	                break;
	            }
	        }

	        return trabajadoresConMenorPromedio.get(0);
	    }

	    return null;
	}
	
	*/
	
	

	
	
}
