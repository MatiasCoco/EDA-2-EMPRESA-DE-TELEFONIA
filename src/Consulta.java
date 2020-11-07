
public class Consulta {
	private Integer nroConsulta;
	private String descripcion;
	private Estado estado;
	private Empleado empleadoAsignado=null;
	private Integer numeroConsulta;
	
	public Consulta(Integer nroConsulta, String descripcion, Estado estado) {
		super();
		this.nroConsulta = nroConsulta;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Enum getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void asignarEmpleado(Empleado empleadoAsignar) {
		empleadoAsignado=empleadoAsignar;
		
	}
	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}
	public Integer getNroConsulta() {
		return numeroConsulta;
	}

	
	

}
