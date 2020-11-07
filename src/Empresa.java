import java.util.HashSet;
import java.util.Set;

public class Empresa {

	private String nombreDeLaEmpresa;
	private Set<Empleado> listaDeEmpleados;
	private Set<Cliente> listaDeClientes;
	private Set<PlanTelefonico> listaDePlanes;
	private Set<Equipo> listaDeEquiposDisponibles;
	
	private Integer contadorConsultas=0;

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
	public void reclamoTecnico(Tecnico tecnicoAsignar, String descripcionReclamo,Cliente cliente) {
		
		contadorConsultas++;
		Consulta reclamo= new Reclamo (contadorConsultas,descripcionReclamo,false,cliente);
		reclamo.asignarEmpleado(tecnicoAsignar);
		consultas.add(reclamo);
		
	}
	public Boolean cambiarEstadoReclamo(Integer nroReclamo,Boolean estado) {
		for (consulta reclamo : consultas ) {
			if(reclamo.getNroReclamo().equals(nroReclamo))
				reclamo.setEstado(estado);
		}
	}

	
}
