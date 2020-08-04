package ec.ups.edu.ejb;

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
	

}
