package ec.ups.edu.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CitaMedica {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	
	private String sintomas;
	
	private String alergias;
	
	private String enfermedadesAnteriores;
	
	
	private String fecha;
	
	@ManyToOne
	private Paciente paciente;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "citaMedicaa")
	private SignosVitales signosVitales;


	public CitaMedica() {
		
	}


	public CitaMedica(int codigo, String sintomas, String alergias, String enfermedadesAnteriores, String fecha,
			Paciente paciente, SignosVitales signosVitales) {
		super();
		this.codigo = codigo;
		this.sintomas = sintomas;
		this.alergias = alergias;
		this.enfermedadesAnteriores = enfermedadesAnteriores;
		this.fecha = fecha;
		this.paciente = paciente;
		this.signosVitales = signosVitales;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getSintomas() {
		return sintomas;
	}


	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}


	public String getAlergias() {
		return alergias;
	}


	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	public String getEnfermedadesAnteriores() {
		return enfermedadesAnteriores;
	}


	public void setEnfermedadesAnteriores(String enfermedadesAnteriores) {
		this.enfermedadesAnteriores = enfermedadesAnteriores;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public SignosVitales getSignosVitales() {
		return signosVitales;
	}


	public void setSignosVitales(SignosVitales signosVitales) {
		this.signosVitales = signosVitales;
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
		CitaMedica other = (CitaMedica) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
