import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;
	private Set<Venta> listaDeVentas;

	public Empresa(String nombreDeLaEmpresa) {
		
		this.nombreDeLaEmpresa=nombreDeLaEmpresa;
		
		this.listaDeEmpleados= new HashSet<Empleado>();
		this.listaDeClientes= new HashSet<Cliente>();
		this.listaDePlanes= new HashSet<PlanTelefonico>();
		this.listaDeEquiposDisponibles= new HashSet<Equipo>();
	}
	
	public Boolean agregarEmpleado(Empleado empleado) {
		return listaDeEmpleados.add(empleado);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Boolean agregarVenta(Venta venta) {
		Vendedor vendedor= buscarVendedor(venta.getVendedor().getNumeroDeEmpleado());
		if(listaDeEmpleados.contains(vendedor) &&
				listaDeEquiposDisponibles.contains(venta.getEquipoVendido()) &&
				listaDePlanes.contains(venta.getPlanVendido())) {
			if(listaDeVentas.add(venta))
			vendedor.setComision();
			return true;
		}
		return false;
	}
	
	public Vendedor buscarVendedor(Integer numeroDeEmpleado) {
		Vendedor vendedorBuscado = null;
		for (Empleado empleado : listaDeEmpleados) {
			if(empleado.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
				vendedorBuscado = (Vendedor) empleado;
			}
		}
		return vendedorBuscado;
	}

	public String getNombreDeLaEmpresa() {
		return nombreDeLaEmpresa;
	}

	public void setNombreDeLaEmpresa(String nombreDeLaEmpresa) {
		this.nombreDeLaEmpresa = nombreDeLaEmpresa;
	}

	public Set<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public Set<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public Set<PlanTelefonico> getListaDePlanes() {
		return listaDePlanes;
	}

	public Set<Equipo> getListaDeEquiposDisponibles() {
		return listaDeEquiposDisponibles;
	}

	public Set<Venta> getListaDeVentas() {
		return listaDeVentas;
	}
}
