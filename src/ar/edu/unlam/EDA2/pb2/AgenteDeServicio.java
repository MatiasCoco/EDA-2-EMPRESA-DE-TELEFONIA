package ar.edu.unlam.EDA2.pb2;

public class AgenteDeServicio extends Empleado {
	
	private Boolean ocupado;
	
	public AgenteDeServicio(Integer numeroDeEmpleado, Double sueldo, String nombre, Integer dni, Boolean ocupado) {
		super(numeroDeEmpleado, sueldo, nombre, dni);
		this.ocupado = ocupado;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
}
