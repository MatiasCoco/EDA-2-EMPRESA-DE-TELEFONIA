
public class Reclamo {
	
	private Integer id;
	private String descripcion;
	private Cliente cliente;
	private Empleado empleadoAsignado;
	private Estado estado;
	
	public Reclamo(Integer id, String descripcion, Cliente cliente, Estado estado) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.cliente = cliente;
		this.estado = estado;
	}
	
	public void asignarEmpleado (Empleado asignado) {
		
		this.empleadoAsignado = asignado;
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Reclamo other = (Reclamo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	
	
	
	
	
	
	
}
