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
import ec.ups.edu.modelo.Paciente;

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
	
	
	private String buscarCedula;
	
	private CitaMedica citaEncontrada;
	
	private Paciente paci;
	private String cedulaAjax;
	
	
	
	
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
	
	public String getBuscarCedula() {
		return buscarCedula;
	}




	public void setBuscarCedula(String buscarCedula) {
		this.buscarCedula = buscarCedula;
	}

	
	
	public CitaMedica getCitaEncontrada() {
		return citaEncontrada;
	}




	public void setCitaEncontrada(CitaMedica citaEncontrada) {
		this.citaEncontrada = citaEncontrada;
	}


	

	public Paciente getPaci() {
		return paci;
	}




	public void setPaci(Paciente paci) {
		this.paci = paci;
	}

	
	public String getCedulaAjax() {
		return cedulaAjax;
	}




	public void setCedulaAjax(String cedulaAjax) {
		this.cedulaAjax = cedulaAjax;
	}



	
	/////////////////////////////////
	
	




	







	public String buscarCita() {
		
		System.out.println("llego la cedula++++++++"+ this.buscarCedula);
		
		CitaMedica cita = null;
		List<Paciente> pac = null;
		
		
		
		try {
			
			cita = citaMedicaFacade.find(idCitaPaciente);
			System.out.println("Encontro la cita medica" + cita.getCodigo());
			
			
		} catch (Exception e) {
			System.out.println("No se encontro la cita medica");
		}
		
		try {
			
			System.out.println(this.buscarCedula);
			pac = pacienteFacade.buscarPaciente(buscarCedula);
			
			
		} catch (Exception e) {
			System.out.println("No se encontro un paciente con la cedula ingresada");
		}
		
		
		for (Paciente paciente : pac) {
			if(paciente.getCodigo() == cita.getPaciente().getCodigo()) {
				this.citaEncontrada = cita;
				this.paci = paciente;
				this.cedulaAjax = paciente.getCedula();
				System.out.println("encontro la cita del paciente");
			}
			
		}
		
		
		
	
		
		return null;
	}
	
	
	

}
