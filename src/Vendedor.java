
public class Vendedor extends Empleado {

	private Double comision;
	private final Integer procentejeDeComision = 5;
	
	public Vendedor(Integer numeroDeEmpleado, Double sueldo, String nombre, Integer dni, Double comision) {
		super(numeroDeEmpleado, sueldo, nombre, dni);
		this.comision = comision;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public Integer getProcentejeDeComision() {
		return procentejeDeComision;
	}

}
