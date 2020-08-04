package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.SignosVitales;

@Stateless
public class SignosVitalesFacade extends AbstractFacade<SignosVitales> {
	
	@PersistenceContext(unitName = "PruebaGitHub")
	private EntityManager em1;

	public SignosVitalesFacade() {
		super(SignosVitales.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}

}
