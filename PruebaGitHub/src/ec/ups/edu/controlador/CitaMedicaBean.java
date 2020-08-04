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
public class CitaMedicaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private PacienteFacade pacienteFacade;
	
	
	@EJB
	private CitaMedicaFacade citaFacade;
	
	
	
	private String alergiasPaciente;
	private String EfermedadAnterior;
	private String fechaCita;
	private String sintomaPaciente;
	
	
	private List<Paciente> listPacientes;
	
	
	private int idpaciente;
	
	
	
	
	
	
	@PostConstruct
	public void init() {
		this.listPacientes = pacienteFacade.findAll();

	}


	public CitaMedicaBean() {
		
	}


	public String getAlergiasPaciente() {
		return alergiasPaciente;
	}


	public void setAlergiasPaciente(String alergiasPaciente) {
		this.alergiasPaciente = alergiasPaciente;
	}


	public String getEfermedadAnterior() {
		return EfermedadAnterior;
	}


	public void setEfermedadAnterior(String efermedadAnterior) {
		EfermedadAnterior = efermedadAnterior;
	}


	public String getFechaCita() {
		return fechaCita;
	}


	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}


	public String getSintomaPaciente() {
		return sintomaPaciente;
	}


	public void setSintomaPaciente(String sintomaPaciente) {
		this.sintomaPaciente = sintomaPaciente;
	}
	
	

	
	public List<Paciente> getListPacientes() {
		return listPacientes;
	}


	public void setListPacientes(List<Paciente> listPacientes) {
		this.listPacientes = listPacientes;
	}


	public int getIdpaciente() {
		return idpaciente;
	}


	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}


	//**************************************************
	public String crearCitaMedica() {
		
		
		System.out.println("id----------"+idpaciente);
		
		System.out.println("parametros "+this.sintomaPaciente);
		
		Paciente pas = pacienteFacade.find(this.idpaciente);
		
		System.out.println("si busco si------------"+pas.getCedula());
		
		CitaMedica citaMed = new CitaMedica();
		citaMed.setSintomas(this.sintomaPaciente);
		citaMed.setAlergias(alergiasPaciente);
		citaMed.setEnfermedadesAnteriores(this.EfermedadAnterior);
		citaMed.setFecha(this.fechaCita);
		citaMed.setPaciente(pas);
		
		citaFacade.create(citaMed);
		
		this.listPacientes = pacienteFacade.findAll();
		return null;
	}
	
	

	
	
	

}
