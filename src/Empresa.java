import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;
<<<<<<< HEAD
	private Set <Consulta> listaDeConsultas;
	private Integer contadorConsultas=0;
=======
	private Set<Venta> listaDeVentas;
>>>>>>> b9d0fc9c2b453a44231e36165c6f3cb49b036d3a

	public Empresa(String nombreDeLaEmpresa) {
		
		this.nombreDeLaEmpresa=nombreDeLaEmpresa;
		
		this.listaDeEmpleados= new HashSet<Empleado>();
		this.listaDeClientes= new HashSet<Cliente>();
		this.listaDePlanes= new HashSet<PlanTelefonico>();
		this.listaDeEquiposDisponibles= new HashSet<Equipo>();
		this.listaDeConsultas=new HashSet<Consulta>();
	}
	
	public Boolean agregarEmpleado(Empleado empleado) {
		return listaDeEmpleados.add(empleado);
	}
<<<<<<< HEAD
	public void reclamoTecnico(Tecnico tecnicoAsignar, String descripcionReclamo,Cliente cliente) {
		
		contadorConsultas++;
		Consulta reclamo= new Reclamo (contadorConsultas,descripcionReclamo,Estado.enCurso,cliente,tecnicoAsignar);
		reclamo.asignarEmpleado(tecnicoAsignar);
		listaDeConsultas.add(reclamo);
		
	}
	public Boolean cambiarEstadoReclamo(Integer nroReclamo,Estado estado) {
		for (Consulta consulta : listaDeConsultas){
			if(consulta.getNroConsulta().equals(nroReclamo))
				consulta.setEstado(estado);
				return true;
		}
		return false;
	}

=======
	
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
>>>>>>> b9d0fc9c2b453a44231e36165c6f3cb49b036d3a
}
