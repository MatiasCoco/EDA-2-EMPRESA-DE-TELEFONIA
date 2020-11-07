
public class Venta {
	private Integer numeroDeVenta;
	private Vendedor vendedor;
	private Double totalDeVenta;
	private Equipo equipoVendido;
	private PlanTelefonico planVendido;
	
	public Venta(Integer numeroDeVenta, Vendedor vendedor, Double totalDeVenta, Equipo equipoVendido,
			PlanTelefonico planVendido) {
		super();
		this.numeroDeVenta = numeroDeVenta;
		this.vendedor = vendedor;
		this.totalDeVenta = totalDeVenta;
		this.equipoVendido = equipoVendido;
		this.planVendido = planVendido;
	}

	public Integer getNumeroDeVenta() {
		return numeroDeVenta;
	}

	public void setNumeroDeVenta(Integer numeroDeVenta) {
		this.numeroDeVenta = numeroDeVenta;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Double getTotalDeVenta() {
		return totalDeVenta;
	}

	public void setTotalDeVenta(Double totalDeVenta) {
		this.totalDeVenta = totalDeVenta;
	}

	public Equipo getEquipoVendido() {
		return equipoVendido;
	}

	public void setEquipoVendido(Equipo equipoVendido) {
		this.equipoVendido = equipoVendido;
	}

	public PlanTelefonico getPlanVendido() {
		return planVendido;
	}

	public void setPlanVendido(PlanTelefonico planVendido) {
		this.planVendido = planVendido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeVenta == null) ? 0 : numeroDeVenta.hashCode());
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
		Venta other = (Venta) obj;
		if (numeroDeVenta == null) {
			if (other.numeroDeVenta != null)
				return false;
		} else if (!numeroDeVenta.equals(other.numeroDeVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venta [numeroDeVenta=" + numeroDeVenta + ", vendedor=" + vendedor + ", totalDeVenta=" + totalDeVenta
				+ ", equipoVendido=" + equipoVendido + ", planVendido=" + planVendido + "]";
	}
}
