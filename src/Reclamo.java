
public class Reclamo extends Consulta{
	
	
	
	private Cliente cliente;
	private Empleado empleadoAsignado;
	


	public Reclamo(Integer nroConsulta, String descripcion, Estado estado, Cliente cliente, Empleado empleadoAsignado) {
		super(nroConsulta, descripcion, estado);
		this.cliente = cliente;
		this.empleadoAsignado = empleadoAsignado;
	}

	public void asignarEmpleado (Empleado asignado) {
		
		this.empleadoAsignado = asignado;
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}

	public void setEmpleadoAsignado(Empleado empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}

}
