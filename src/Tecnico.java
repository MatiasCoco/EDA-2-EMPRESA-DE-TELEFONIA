
public class Tecnico extends Empleado {

	private String zonaDeTrabajo;
	private Integer numeroDeCamionetaAsignada;
	
	public Tecnico(String zonaDeTrabajo, Integer numeroDeCamionetaAsignada,Integer numeroDeEmpleado,Double sueldo,Integer dni, String nombre ) {
		
		super(numeroDeEmpleado,sueldo, nombre, dni);
		this.zonaDeTrabajo = zonaDeTrabajo;
		this.numeroDeCamionetaAsignada = numeroDeCamionetaAsignada;
	}
	
	
}
