package ec.ups.edu.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.ups.edu.modelo.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente>{
	
	@PersistenceContext(unitName = "PruebaGitHub")
	private EntityManager em1;

	public PacienteFacade() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}
	
	
	public List<Paciente> buscarPaciente(String cedula) {
		String qu = "SELECT p FROM Paciente p WHERE p.cedula = '"+cedula+"'";
		System.out.println("query-----------"+qu);
		List<Paciente> query =  em1.createQuery(qu).getResultList();
		System.out.println("------Entro al query 2------");
		
		for (Paciente facturaCabecera : query) {
			System.out.println(facturaCabecera.getCedula());	
		}
		return query;
	}

}
