
public class AgenteDeServicio extends Empleado {

	private Sector sector;

	public AgenteDeServicio(Integer numeroDeEmpleado, Double sueldo, String nombre, Integer dni, Sector sector) {
		super(numeroDeEmpleado, sueldo, nombre, dni);
		this.sector = sector;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
}
