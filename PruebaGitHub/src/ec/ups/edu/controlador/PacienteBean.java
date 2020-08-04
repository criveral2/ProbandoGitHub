package ec.ups.edu.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.ups.edu.ejb.CitaMedicaFacade;
import ec.ups.edu.ejb.PacienteFacade;
import ec.ups.edu.modelo.CitaMedica;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PacienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB 
	private PacienteFacade pacienteFacade;
	
	@EJB
	private CitaMedicaFacade citaMedicaFacade;
	
	private List<CitaMedica> listcitasMedicass;
	
	
	private int idCitaPaciente;
	
	@PostConstruct
	public void init() {
		this.listcitasMedicass = citaMedicaFacade.findAll();

	}
	
	


	public PacienteBean() {
		super();
	}




	public List<CitaMedica> getListcitasMedicass() {
		return listcitasMedicass;
	}


	public void setListcitasMedicass(List<CitaMedica> listcitasMedicass) {
		this.listcitasMedicass = listcitasMedicass;
	}




	public int getIdCitaPaciente() {
		return idCitaPaciente;
	}




	public void setIdCitaPaciente(int idCitaPaciente) {
		this.idCitaPaciente = idCitaPaciente;
	}
	
	
	public String buscarCita() {
		
		
		return null;
	}
	
	
	

}
