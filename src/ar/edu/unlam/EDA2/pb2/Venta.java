package ar.edu.unlam.EDA2.pb2;

public class Venta {
	private Integer numeroDeVenta;
	private Vendedor vendedor;
	private Double totalDeVenta;
	private Equipo equipoVendido;
	private Cliente cliente;
	private PlanTelefonico planVendido;
	
	public Venta(Vendedor vendedor, Equipo equipoVendido, PlanTelefonico planVendido, Cliente cliente) {
		super();
		this.vendedor = vendedor;
		this.equipoVendido = equipoVendido;
		this.planVendido = planVendido;
		this.cliente = cliente;
		this.totalDeVenta = getPlanVendido().getPrecio()+getEquipoVendido().getPrecio();
	}
	
	public Venta(Vendedor vendedor, PlanTelefonico planVendido, Cliente cliente) {
		super();
		this.vendedor = vendedor;
		this.planVendido = planVendido;
		this.cliente = cliente;
		this.totalDeVenta = getPlanVendido().getPrecio();
	}
	
	public Venta(Vendedor vendedor, Double totalDeVenta, Equipo equipoVendido, Cliente cliente) {
		super();
		this.vendedor = vendedor;
		this.equipoVendido = equipoVendido;
		this.cliente = cliente;
		this.totalDeVenta =getEquipoVendido().getPrecio();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
