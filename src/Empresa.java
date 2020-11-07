import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;
	private Set <Consulta> listaDeConsultas;
	private Integer contadorConsultas=0;
	private Set<Venta> listaDeVentas;


	public Empresa(String nombreDeLaEmpresa) {

		this.nombreDeLaEmpresa = nombreDeLaEmpresa;

		this.listaDeEmpleados = new HashSet<Empleado>();
		this.listaDeClientes = new HashSet<Cliente>();
		this.listaDePlanes = new HashSet<PlanTelefonico>();
		this.listaDeEquiposDisponibles = new HashSet<Equipo>();
		this.listaDeConsultas=new HashSet<Consulta>();
	}

	public Boolean agregarEmpleado(Empleado empleado) {
		return listaDeEmpleados.add(empleado);
	}

	public Boolean eliminarEquipoViejo(Integer idDelEquipo) {

		for (Equipo equipoViejo : this.listaDeEquiposDisponibles) {

			if (equipoViejo.getCodigoDelProducto().equals(idDelEquipo)) {
				return this.listaDeEquiposDisponibles.remove(equipoViejo);
			}
		}
		return false;
	}
	
	public Boolean agregarEquipo(Equipo equipoNuevo) {
		return this.listaDeEquiposDisponibles.add(equipoNuevo);
	}

	public Boolean agregarPlan(PlanTelefonico planNuevo) {
		return this.listaDePlanes.add(planNuevo);
	}
	
	public HashSet<PlanTelefonico> getPlanesVigentes() {
		return (HashSet<PlanTelefonico>) this.listaDePlanes;
	}
	
	public HashSet<Equipo> getEquiposVigentes() {
		return (HashSet<Equipo>) this.listaDeEquiposDisponibles;
	}
	
	public Equipo buscarEquipo(Equipo equipoDeseado) {	
		for(Equipo equipoActual:this.listaDeEquiposDisponibles) {
			if(equipoActual.equals(equipoDeseado)) {
				return equipoActual;
			}
		}
		
		return null;
	}
	
	public PlanTelefonico buscarPlan(Integer IdplanABuscar) {
		
		for(PlanTelefonico planBuscado : this.listaDePlanes) {
			
			if(planBuscado.getId().equals(IdplanABuscar)) {
				return planBuscado;
			}
		}
		return null;
	}

	public void recepcionConsulta(Empleado empleadoAsignar, String descripcionConsulta,Cliente cliente) {
		
		contadorConsultas++;
		Consulta consulta= new Consulta (contadorConsultas,descripcionConsulta,Estado.enCurso,cliente,empleadoAsignar);
		consulta.asignarEmpleado(empleadoAsignar);
		listaDeConsultas.add(consulta);
		
	}
	public Boolean cambiarEstadoReclamo(Integer nroReclamo,Estado estado) {
		for (Consulta consulta : listaDeConsultas){
			if(consulta.getNroConsulta().equals(nroReclamo))
				consulta.setEstado(estado);
				return true;
		}
		return false;
	}


	

	public Boolean agregarVenta(Venta venta) {
        Vendedor vendedor= buscarVendedor(venta.getVendedor().getNumeroDeEmpleado());
        if(listaDeEmpleados.contains(vendedor) &&
                listaDeEquiposDisponibles.contains(venta.getEquipoVendido()) &&
                listaDePlanes.contains(venta.getPlanVendido())) {
            if(listaDeVentas.add(venta)) {
            vendedor.setComision();
            return true;
            }
        }
        return false;
    }

	public Boolean ModificarElPrecioDeUnPlanTelefonico(Double precioActualizado, Integer IdPlanQueDeseoModificar) {
		
		if(this.buscarPlan(IdPlanQueDeseoModificar)!=null) {
			
			this.buscarPlan(IdPlanQueDeseoModificar).setPrecio(precioActualizado);

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

	public Boolean eliminarPlan(Integer id) {

        if(this.buscarPlan(id)!=null) {
            return this.listaDePlanes.remove(this.buscarPlan(id));
        }
        return false;
	}

}
