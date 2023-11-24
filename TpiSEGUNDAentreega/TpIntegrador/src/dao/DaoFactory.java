package dao;

public class DaoFactory {

	
	 public static IncidenteDao geIncidenteDAO() {
		    return new IncidenteDaoImpl();
		  }

	
	 
}
