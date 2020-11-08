import java.util.ArrayList;

public class Tecnico extends Empleado {

	private String zonaDeTrabajo;
	private Integer numeroDeCamionetaAsignada;
	private ArrayList<Equipo> equiposEnReparacion;
	
	public Tecnico(String zonaDeTrabajo, Integer numeroDeCamionetaAsignada,Integer numeroDeEmpleado,Double sueldo,Integer dni, String nombre ) {
		
		super(numeroDeEmpleado,sueldo, nombre, dni);
		this.zonaDeTrabajo = zonaDeTrabajo;
		this.numeroDeCamionetaAsignada = numeroDeCamionetaAsignada;
		this.equiposEnReparacion = new ArrayList<Equipo>();
	}
	
	public Tecnico(String zonaDeTrabajo, Integer numeroDeEmpleado,Double sueldo,Integer dni, String nombre ) {
		super(numeroDeEmpleado,sueldo, nombre, dni);
		this.zonaDeTrabajo = zonaDeTrabajo;
		this.equiposEnReparacion = new ArrayList<Equipo>();
	}
	
	public Boolean agregarEquipoEnReparacion(Equipo equipo) {
		return this.equiposEnReparacion.add(equipo);
	}
	
	public Boolean finalizarReparacion(Equipo equipo) {
		return this.equiposEnReparacion.remove(equipo);
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
