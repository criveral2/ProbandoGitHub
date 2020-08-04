package ec.ups.edu.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.ups.edu.ejb.CitaMedicaFacade;
import ec.ups.edu.ejb.SignosVitalesFacade;
import ec.ups.edu.modelo.CitaMedica;
import ec.ups.edu.modelo.Paciente;
import ec.ups.edu.modelo.SignosVitales;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SignosVitalesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@EJB
	private SignosVitalesFacade signosVitalesFacade;
	
	@EJB
	private CitaMedicaFacade citasMedicasFacade;
	
	
	private int presionSig;
	
	private int fresuenciaCardiacaSig;
	
	private int fresuenciaRespiratoriaSig;
	
	private String temperaturaSig;
	
	private String saturacionSig;
	
	private int idCitaMedica;
	
	private List<CitaMedica> listcitasMedicas;
	
	
	
	
	@PostConstruct
	public void init() {
		
		this.listcitasMedicas = citasMedicasFacade.findAll();
		
	}


	public SignosVitalesBean() {
		
	}


	public int getPresionSig() {
		return presionSig;
	}


	public void setPresionSig(int presionSig) {
		this.presionSig = presionSig;
	}


	public int getFresuenciaCardiacaSig() {
		return fresuenciaCardiacaSig;
	}


	public void setFresuenciaCardiacaSig(int fresuenciaCardiacaSig) {
		this.fresuenciaCardiacaSig = fresuenciaCardiacaSig;
	}


	public int getFresuenciaRespiratoriaSig() {
		return fresuenciaRespiratoriaSig;
	}


	public void setFresuenciaRespiratoriaSig(int fresuenciaRespiratoriaSig) {
		this.fresuenciaRespiratoriaSig = fresuenciaRespiratoriaSig;
	}


	public String getTemperaturaSig() {
		return temperaturaSig;
	}


	public void setTemperaturaSig(String temperaturaSig) {
		this.temperaturaSig = temperaturaSig;
	}


	public String getSaturacionSig() {
		return saturacionSig;
	}


	public void setSaturacionSig(String saturacionSig) {
		this.saturacionSig = saturacionSig;
	}


	public List<CitaMedica> getListcitasMedicas() {
		return listcitasMedicas;
	}


	public void setListcitasMedicas(List<CitaMedica> listcitasMedicas) {
		this.listcitasMedicas = listcitasMedicas;
	}
	
	
	
	
	public int getIdCitaMedica() {
		return idCitaMedica;
	}


	public void setIdCitaMedica(int idCitaMedica) {
		this.idCitaMedica = idCitaMedica;
	}

	
	

	public String crearSignos() {
		

		System.out.println("id----------"+ this.idCitaMedica);
		
		System.out.println("parametros "+this.presionSig);
		
		CitaMedica cita = citasMedicasFacade.find(this.idCitaMedica);
		
		System.out.println("si busco si------------"+cita.getAlergias());
		
		SignosVitales signos = new SignosVitales();
		
		signos.setPresion(this.presionSig);
		signos.setFresuenciaCardiaca(this.fresuenciaCardiacaSig);
		signos.setFresuenciaRespiratoria(this.fresuenciaRespiratoriaSig);
		signos.setTemperatura(this.temperaturaSig);
		signos.setSaturacion(this.saturacionSig);
		signos.setCitaMedicaa(cita);
		
		
		signosVitalesFacade.create(signos);
		
	
		
		return null;
	}
	
	
	

}
