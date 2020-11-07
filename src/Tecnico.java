
public class Tecnico extends Empleado {

	private String zonaDeTrabajo;
	private Integer numeroDeCamionetaAsignada;
	
	public Tecnico(String zonaDeTrabajo, Integer numeroDeCamionetaAsignada,Integer numeroDeEmpleado,Double sueldo,Integer dni, String nombre ) {
		
		super(numeroDeEmpleado,sueldo, nombre, dni);
		this.zonaDeTrabajo = zonaDeTrabajo;
		this.numeroDeCamionetaAsignada = numeroDeCamionetaAsignada;
	}

	public String getZonaDeTrabajo() {
		return zonaDeTrabajo;
	}

	public void setZonaDeTrabajo(String zonaDeTrabajo) {
		this.zonaDeTrabajo = zonaDeTrabajo;
	}

	public Integer getNumeroDeCamionetaAsignada() {
		return numeroDeCamionetaAsignada;
	}

	public void setNumeroDeCamionetaAsignada(Integer numeroDeCamionetaAsignada) {
		this.numeroDeCamionetaAsignada = numeroDeCamionetaAsignada;
	}
}
