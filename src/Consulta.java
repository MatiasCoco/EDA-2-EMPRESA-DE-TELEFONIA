
public class Consulta {
	private Integer nroConsulta;
	private String descripcion;
	private Estado estado;
	private Empleado empleadoAsignado=null;
	private Cliente cliente;
	private Tecnico tecnico=null;
	
	public Consulta(Integer nroConsulta, String descripcion, Estado estado,Cliente cliente) {
		super();
		this.nroConsulta = nroConsulta;
		this.descripcion = descripcion;
		this.estado = estado;
		this.cliente=cliente;
	}
	
	public Consulta(Integer nroConsulta, String descripcion, Estado estado,Cliente cliente, Tecnico tecnico) {
		super();
		this.nroConsulta = nroConsulta;
		this.descripcion = descripcion;
		this.estado = estado;
		this.cliente=cliente;
		this.tecnico=tecnico;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void asignarEmpleado(Empleado empleadoAsignar) {
		empleadoAsignado=empleadoAsignar;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public Cliente getClienteDeReclamo() {
		return cliente;
	}
	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}
	public Integer getNroConsulta() {
		return nroConsulta;
	}

	
	

}
