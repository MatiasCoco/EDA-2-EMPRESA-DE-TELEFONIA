import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;

	public Empresa(String nombreDeLaEmpresa) {

		this.nombreDeLaEmpresa = nombreDeLaEmpresa;

		this.listaDeEmpleados = new HashSet<Empleado>();
		this.listaDeClientes = new HashSet<Cliente>();
		this.listaDePlanes = new HashSet<PlanTelefonico>();
		this.listaDeEquiposDisponibles = new HashSet<Equipo>();
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
	
	public Boolean ModificarElPrecioDeUnPlanTelefonico(Double precioActualizado, Integer IdPlanQueDeseoModificar) {
		
		if(this.buscarPlan(IdPlanQueDeseoModificar)!=null) {
			
			this.buscarPlan(IdPlanQueDeseoModificar).setPrecio(precioActualizado);
			return true;
		}
		return false;
	}
	
	public Boolean eliminarPlan(Integer id) {
			
			if(this.buscarPlan(id)!=null) {
				return this.listaDePlanes.remove(this.buscarPlan(id));
			}
		return false;
	}
}
