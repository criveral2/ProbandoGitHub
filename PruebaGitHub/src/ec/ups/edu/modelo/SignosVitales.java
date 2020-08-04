package ec.ups.edu.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SignosVitales {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private int presion;
	
	private int fresuenciaCardiaca;
	
	private int fresuenciaRespiratoria;
	
	private String temperatura;
	
	private String saturacion;
	
	
	@OneToOne
	private CitaMedica citaMedicaa;


	public SignosVitales() {
		
	}


	public SignosVitales(int codigo, int presion, int fresuenciaCardiaca, int fresuenciaRespiratoria,
			String temperatura, String saturacion, CitaMedica citaMedicaa) {
	
		this.codigo = codigo;
		this.presion = presion;
		this.fresuenciaCardiaca = fresuenciaCardiaca;
		this.fresuenciaRespiratoria = fresuenciaRespiratoria;
		this.temperatura = temperatura;
		this.saturacion = saturacion;
		this.citaMedicaa = citaMedicaa;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getPresion() {
		return presion;
	}


	public void setPresion(int presion) {
		this.presion = presion;
	}


	public int getFresuenciaCardiaca() {
		return fresuenciaCardiaca;
	}


	public void setFresuenciaCardiaca(int fresuenciaCardiaca) {
		this.fresuenciaCardiaca = fresuenciaCardiaca;
	}


	public int getFresuenciaRespiratoria() {
		return fresuenciaRespiratoria;
	}


	public void setFresuenciaRespiratoria(int fresuenciaRespiratoria) {
		this.fresuenciaRespiratoria = fresuenciaRespiratoria;
	}


	public String getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}


	public String getSaturacion() {
		return saturacion;
	}


	public void setSaturacion(String saturacion) {
		this.saturacion = saturacion;
	}


	public CitaMedica getCitaMedicaa() {
		return citaMedicaa;
	}


	public void setCitaMedicaa(CitaMedica citaMedicaa) {
		this.citaMedicaa = citaMedicaa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignosVitales other = (SignosVitales) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
