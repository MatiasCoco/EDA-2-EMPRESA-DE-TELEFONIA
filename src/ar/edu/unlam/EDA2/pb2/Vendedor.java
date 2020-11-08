package ar.edu.unlam.EDA2.pb2;

public class Vendedor extends Empleado {

	private Double comision;
	private final Double PORCENTAJE_DE_COMISION = 0.05;
	
	public Vendedor(Integer numeroDeEmpleado, Double sueldo, String nombre, Integer dni) {
		super(numeroDeEmpleado, sueldo, nombre, dni);
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double venta) {
		this.comision = venta * getPorcentajeDeComision();
	}

	public Double getPorcentajeDeComision() {
		return PORCENTAJE_DE_COMISION;
	}

	@Override
	public String toString() {
		return "Vendedor [getNombre()=" + getNombre() + ", getDni()=" + getDni() + ", getNumeroDeEmpleado()="
				+ getNumeroDeEmpleado() + ", getSueldo()=" + getSueldo() + ", comision=" + comision
				+ ", PORCENTAJE_DE_COMISION=" + PORCENTAJE_DE_COMISION + "]";
	}
	
}
