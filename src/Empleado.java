
public class Empleado extends Persona {

	private Integer numeroDeEmpleado;
	private Double sueldo;

	public Empleado(Integer numeroDeEmpleado, Double sueldo, String nombre, Integer dni) {
		super(nombre, dni);
		this.numeroDeEmpleado = numeroDeEmpleado;
		this.sueldo = sueldo;
	}

	public Integer getNumeroDeEmpleado() {
		return numeroDeEmpleado;
	}

	public void setNumeroDeEmpleado(Integer numeroDeEmpleado) {
		this.numeroDeEmpleado = numeroDeEmpleado;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroDeEmpleado == null) ? 0 : numeroDeEmpleado.hashCode());
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
		Empleado other = (Empleado) obj;
		if (numeroDeEmpleado == null) {
			if (other.numeroDeEmpleado != null)
				return false;
		} else if (!numeroDeEmpleado.equals(other.numeroDeEmpleado))
			return false;
		return true;
	}

}
