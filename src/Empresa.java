import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;
	private Set<Consulta> listaDeConsultas;
	private Integer contadorConsultas = 0;
	private Set<Venta> listaDeVentas;

	public Empresa(String nombreDeLaEmpresa) {
		this.nombreDeLaEmpresa = nombreDeLaEmpresa;
		this.listaDeEmpleados = new HashSet<Empleado>();
		this.listaDeClientes = new HashSet<Cliente>();
		this.listaDePlanes = new HashSet<PlanTelefonico>();
		this.listaDeEquiposDisponibles = new HashSet<Equipo>();
		this.listaDeConsultas = new HashSet<Consulta>();
		this.listaDeVentas = new HashSet<Venta>();
	}

	public Boolean agregarEmpleado(Empleado empleado) {
		return listaDeEmpleados.add(empleado);
	}

	public Vendedor buscarVendedor(Integer numeroDeEmpleado) {
		Vendedor vendedorBuscado = null;
		for (Empleado empleado : listaDeEmpleados) {
			if (empleado.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
				vendedorBuscado = (Vendedor) empleado;
			}
		}
		return vendedorBuscado;
	}

	public AgenteDeServicio buscarAgente(Integer numeroDeEmpleado) {
		AgenteDeServicio agenteBuscado = null;
		for (Empleado empleado : listaDeEmpleados) {
			if (empleado.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
				agenteBuscado = (AgenteDeServicio) empleado;
			}
		}
		return agenteBuscado;
	}

	public Tecnico buscarTecnico(Integer numeroDeEmpleado) {
		Tecnico tecnicoBuscado = null;
		for (Empleado empleado : listaDeEmpleados) {
			if (empleado.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
				tecnicoBuscado = (Tecnico) empleado;
			}
		}
		return tecnicoBuscado;
	}

	public Boolean agregarEquipo(Equipo equipoNuevo) {
		return this.listaDeEquiposDisponibles.add(equipoNuevo);
	}

	public Equipo buscarEquipo(Equipo equipoDeseado) {
		for (Equipo equipoActual : this.listaDeEquiposDisponibles) {
			if (equipoActual.equals(equipoDeseado)) {
				return equipoActual;
			}
		}
		return null;
	}

	public HashSet<Equipo> getEquiposVigentes() {
		return (HashSet<Equipo>) this.listaDeEquiposDisponibles;
	}

	public Boolean eliminarEquipoViejo(Integer idDelEquipo) {

		for (Equipo equipoViejo : this.listaDeEquiposDisponibles) {

			if (equipoViejo.getCodigoDelProducto().equals(idDelEquipo)) {
				return this.listaDeEquiposDisponibles.remove(equipoViejo);
			}
		}
		return false;
	}

	public Boolean agregarPlan(PlanTelefonico planNuevo) {
		return this.listaDePlanes.add(planNuevo);
	}

	public PlanTelefonico buscarPlan(Integer IdplanABuscar) {

		for (PlanTelefonico planBuscado : this.listaDePlanes) {

			if (planBuscado.getId().equals(IdplanABuscar)) {
				return planBuscado;
			}
		}
		return null;
	}

	public Boolean ModificarElPrecioDeUnPlanTelefonico(Double precioActualizado, Integer IdPlanQueDeseoModificar) {

		if (this.buscarPlan(IdPlanQueDeseoModificar) != null) {

		}
		if (this.listaDePlanes.contains(buscarPlan(IdPlanQueDeseoModificar))) {

			this.buscarPlan(IdPlanQueDeseoModificar).setPrecio(precioActualizado);
			return true;
		}
		return false;
	}

	public Boolean eliminarPlan(Integer id) {

		if (this.buscarPlan(id) != null) {
			return this.listaDePlanes.remove(this.buscarPlan(id));
		}

		if (this.listaDePlanes.contains(buscarPlan(id))) {
			return this.listaDePlanes.remove(this.buscarPlan(id));
		}
		return false;
	}

	public HashSet<PlanTelefonico> getPlanesVigentes() {
		return (HashSet<PlanTelefonico>) this.listaDePlanes;
	}

	public Boolean agregarVenta(Venta venta) {
		Vendedor vendedor = buscarVendedor(venta.getVendedor().getNumeroDeEmpleado());
		venta.setNumeroDeVenta(listaDeVentas.size() + 1);

		if (planYEquipoVendido(venta, vendedor)) {
			return true;
		}
		
		else if (planVendido(venta, vendedor)) {
			return true;
		}
		
		else if (equipoVendido(venta, vendedor)) {
			return true;
		}
		
		return false;
	}

	private Boolean planVendido(Venta venta, Vendedor vendedor) {
		if (listaDeEmpleados.contains(vendedor) && listaDePlanes.contains(venta.getPlanVendido())
				&& venta.getEquipoVendido() == null) {
			if (listaDeVentas.add(venta)) {
				if (!this.listaDeClientes.contains(venta.getCliente())) {
					this.listaDeClientes.add(venta.getCliente());
					this.buscarCliente(venta.getCliente().getNumeroDeCliente())
							.setPlanDelCliente(venta.getPlanVendido());
				}
				vendedor.setComision(venta.getTotalDeVenta());
				return true;
			}
		}
		return false;
	}

	private Boolean equipoVendido(Venta venta, Vendedor vendedor) {
		if (listaDeEmpleados.contains(vendedor) && listaDeEquiposDisponibles.contains(venta.getEquipoVendido())
				&& venta.getPlanVendido() == null) {
			if (listaDeVentas.add(venta)) {
				if (!this.listaDeClientes.contains(venta.getCliente())) {
					this.listaDeClientes.add(venta.getCliente());
				}
				vendedor.setComision(venta.getTotalDeVenta());
				return true;
			}
		}
		return false;
	}

	private Boolean planYEquipoVendido(Venta venta, Vendedor vendedor) {
		if (listaDeEmpleados.contains(vendedor) && listaDeEquiposDisponibles.contains(venta.getEquipoVendido())
				&& listaDePlanes.contains(venta.getPlanVendido())) {
			if (listaDeVentas.add(venta)) {
				if (!this.listaDeClientes.contains(venta.getCliente())) {
					this.listaDeClientes.add(venta.getCliente());
					this.buscarCliente(venta.getCliente().getNumeroDeCliente())
							.setPlanDelCliente(venta.getPlanVendido());
				}
				vendedor.setComision(venta.getTotalDeVenta());
				return true;
			}
		}

		return false;
	}

	public Cliente buscarCliente(Integer numeroCliente) {
		Cliente clienteBuscado = null;
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getNumeroDeCliente().equals(numeroCliente)) {
				clienteBuscado = cliente;
			}
		}
		return clienteBuscado;
	}
	
	public Vendedor buscarVendedorPorVentaRealizada(Integer numeroDeVenta) {
		Vendedor vendedorBuscado = null;
		
		for (Venta venta : this.listaDeVentas) {
			if (venta.getNumeroDeVenta().equals(numeroDeVenta)) {
				vendedorBuscado = venta.getVendedor();
				return vendedorBuscado;
			}
		}
		return vendedorBuscado;
	}

	public Boolean cambiarPlanCliente(Integer numeroCliente, Integer idPlanTelefonico) {
		if (this.listaDeClientes.contains(buscarCliente(numeroCliente))
				&& this.listaDePlanes.contains(buscarPlan(idPlanTelefonico))) {
			buscarCliente(numeroCliente).setPlanDelCliente(buscarPlan(idPlanTelefonico));
			return true;
		}
		return false;
	}

	public Boolean recepcionConsulta(Integer numeroAgente, String descripcionConsulta, Cliente cliente) {
		AgenteDeServicio representante = buscarAgente(numeroAgente);
		if (this.listaDeEmpleados.contains(representante) && this.listaDeClientes.contains(cliente)) {
			contadorConsultas++;
			Consulta consulta = new Consulta(contadorConsultas, descripcionConsulta, Estado.enCurso, cliente);
			representante.setOcupado(true);
			consulta.asignarEmpleado(representante);
			return this.listaDeConsultas.add(consulta);
		}
		return false;
	}
	
	public ArrayList<Consulta> buscarConsultaPorCliente(Integer nroCliente){
		ArrayList<Consulta> listaDeConsultas= new ArrayList<Consulta>();
		Cliente clienteObtenido=buscarCliente(nroCliente);
		
		if(clienteObtenido!=null) {
			
			for(Consulta consultaActual:this.listaDeConsultas) {
				
				if(consultaActual.getClienteDeReclamo().equals(clienteObtenido)) {
					 listaDeConsultas.add(consultaActual);
				}
			}	
		}
		return listaDeConsultas;	
	}

	public Boolean cambiarEstadoConsulta(Integer nroConsulta, Estado estado) {
		for (Consulta consulta : listaDeConsultas) {
			if (consulta.getNroConsulta().equals(nroConsulta))
				consulta.setEstado(estado);
			buscarAgente(consulta.getEmpleadoAsignado().getNumeroDeEmpleado()).setOcupado(false);
			return true;
		}
		return false;
	}

	public Boolean recepcionConsulta(Integer numeroAgente, String descripcionConsulta, Cliente cliente,
			Integer numeroTecnico, Equipo equipo) {
		AgenteDeServicio representante = buscarAgente(numeroAgente);
		if (this.listaDeEmpleados.contains(representante) && this.listaDeClientes.contains(cliente)) {
			contadorConsultas++;
			Consulta consulta = new Consulta(contadorConsultas, descripcionConsulta, Estado.enCurso, cliente, buscarTecnico(numeroTecnico));
			representante.setOcupado(true);
			consulta.asignarEmpleado(representante);
			equipoEnReparacion(numeroTecnico, equipo);
			return this.listaDeConsultas.add(consulta);
		}
		return false;
	}

	public Set<Consulta> getListaDeConsultas() {
		return listaDeConsultas;
	}

	public Boolean equipoEnReparacion(Integer numeroTecnico, Equipo equipo) {
		Tecnico tecnico = buscarTecnico(numeroTecnico);
		if (this.listaDeEmpleados.contains(tecnico) && this.listaDeEquiposDisponibles.contains(equipo)) {
			return tecnico.agregarEquipoEnReparacion(equipo);
		}
		return false;
	}

	public Boolean finzaliarReparacion(Integer numeroTecnico, Equipo equipo) {
		Tecnico tecnico = buscarTecnico(numeroTecnico);
		if (this.listaDeEmpleados.contains(tecnico) && this.listaDeEquiposDisponibles.contains(equipo)) {
			return tecnico.finalizarReparacion(equipo);
		}
		return false;
	}
	
	public Consulta buscarConsulta(Integer nroDeConsulta) {
		
		for(Consulta consultaActual: this.listaDeConsultas) {
			if(consultaActual.getNroConsulta().equals(nroDeConsulta)) {
				
				return consultaActual;
			}
		}
		return null;
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
