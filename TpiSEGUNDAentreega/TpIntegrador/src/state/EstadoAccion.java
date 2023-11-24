package state;

import entidades.Incidente;

public enum EstadoAccion implements Estado {
	PENDIENTE {
        @Override
        public void accion(Incidente incidente) {
            System.out.println(" PENDIENTE, contactando a el técnico");
            
        }

        @Override
        public String toString() {
            return "PENDIENTE";
        }
    },
    RESOLVIENDOSE {
        @Override
        public void accion(Incidente incidente) {
            System.out.println("RESOLVIENDOSE, los tecnicos estan trabajando en el incidenteE");
            
        }

        @Override
        public String toString() {
            return "CONSULTANDOSE";
        }
    },
    RESUELTO {
        @Override
        public void accion(Incidente incidente) {
            System.out.println("Estado RESUELTO, notificar al cliente que puede volver a operar su servicio ");
            
        }

        @Override
        public String toString() {
            return "RESUELTO";
        }
    }


	
	



}
