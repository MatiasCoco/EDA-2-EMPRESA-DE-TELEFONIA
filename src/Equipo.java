
public class Equipo {

	private String nombreDelEquipo;
	private Integer codigoDelProducto;
	private Double precio;
	
	public Equipo(String nombreDelEquipo, Integer codigoDelProducto, Double precio) {
		super();
		this.nombreDelEquipo = nombreDelEquipo;
		this.codigoDelProducto = codigoDelProducto;
		this.precio = precio;
	}

	public String getNombreDelEquipo() {
		return nombreDelEquipo;
	}

	public void setNombreDelEquipo(String nombreDelEquipo) {
		this.nombreDelEquipo = nombreDelEquipo;
	}

	public Integer getCodigoDelProducto() {
		return codigoDelProducto;
	}

	public void setCodigoDelProducto(Integer codigoDelProducto) {
		this.codigoDelProducto = codigoDelProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDelProducto == null) ? 0 : codigoDelProducto.hashCode());
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
		Equipo other = (Equipo) obj;
		if (codigoDelProducto == null) {
			if (other.codigoDelProducto != null)
				return false;
		} else if (!codigoDelProducto.equals(other.codigoDelProducto))
			return false;
		return true;
	}
}
