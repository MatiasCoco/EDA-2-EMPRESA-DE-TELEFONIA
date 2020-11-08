package ar.edu.unlam.EDA2.pb2;

public class Cliente extends Persona {

	private Integer numeroDeCliente;
	private PlanTelefonico planDelCliente; 
	private Integer numeroDeTelefono;
	
	public Cliente(String nombre, Integer dni, Integer numeroDeCliente, PlanTelefonico planDelCliente,
			Integer numeroDeTelefono) {
		super(nombre, dni);
		this.numeroDeCliente = numeroDeCliente;
		this.planDelCliente = planDelCliente;
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	public Cliente(String nombre, Integer dni, Integer numeroDeCliente,
			Integer numeroDeTelefono) {
		super(nombre, dni);
		this.numeroDeCliente = numeroDeCliente;
		this.numeroDeTelefono = numeroDeTelefono;
	}

	public Integer getNumeroDeCliente() {
		return numeroDeCliente;
	}

	public void setNumeroDeCliente(Integer numeroDeCliente) {
		this.numeroDeCliente = numeroDeCliente;
	}

	public PlanTelefonico getPlanDelCliente() {
		return planDelCliente;
	}

	public void setPlanDelCliente(PlanTelefonico planDelCliente) {
		this.planDelCliente = planDelCliente;
	}

	public Integer getNumeroDeTelefono() {
		return numeroDeTelefono;
	}

	public void setNumeroDeTelefono(Integer numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroDeCliente == null) ? 0 : numeroDeCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (numeroDeCliente == null) {
			if (other.numeroDeCliente != null)
				return false;
		} else if (!numeroDeCliente.equals(other.numeroDeCliente))
			return false;
		return true;
	}
}
