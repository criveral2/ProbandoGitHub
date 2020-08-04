package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.CitaMedica;

@Stateless
public class CitaMedicaFacade extends AbstractFacade<CitaMedica>{
	
	@PersistenceContext(unitName = "PruebaGitHub")
	private EntityManager em1;

	public CitaMedicaFacade() {
		super(CitaMedica.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}

}
