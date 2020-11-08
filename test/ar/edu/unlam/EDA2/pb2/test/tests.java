package ar.edu.unlam.EDA2.pb2.test;
import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.EDA2.pb2.AgenteDeServicio;
import ar.edu.unlam.EDA2.pb2.Cliente;
import ar.edu.unlam.EDA2.pb2.Empleado;
import ar.edu.unlam.EDA2.pb2.Empresa;
import ar.edu.unlam.EDA2.pb2.Equipo;
import ar.edu.unlam.EDA2.pb2.Estado;
import ar.edu.unlam.EDA2.pb2.PlanTelefonico;
import ar.edu.unlam.EDA2.pb2.Tecnico;
import ar.edu.unlam.EDA2.pb2.Vendedor;
import ar.edu.unlam.EDA2.pb2.Venta;

public class tests {

	@Test
	public void queSePuedaCrearUnaEmpresa() {
		Empresa empresa = new Empresa("sarasa");

		String va = empresa.getNombreDeLaEmpresa();
		String ve = "sarasa";

		assertEquals(ve, va);
	}

	@Test
	public void queSePuedaAgregarUnEmpleado() {

		Empresa empresa = new Empresa("sarasa");
		Empleado matias = new Tecnico("Zona 1", 1, 123, 50.0, 4175758, "Matias");

		Boolean ve = empresa.agregarEmpleado(matias);
		Boolean va = true;

		assertEquals(ve, va);
	}

	@Test
	public void queSePuedaBuscarUnVendedor() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new Vendedor(1, 28000.0, "Jose", 41728327);

		empresa.agregarEmpleado(jose);

		Vendedor va = empresa.buscarVendedor(1);

		assertEquals(jose, va);
	}

	@Test
	public void queSePuedaAgregarUnaVenta() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new Vendedor(1, 28.000, "Jose", 41728327);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);

		Venta nuevaVenta = new Venta(empresa.buscarVendedor(1), equipo, plan, nuevoCliente);

		Boolean va = empresa.agregarVenta(nuevaVenta);
		Boolean ve = true;

		assertEquals(ve, va);
	}

	@Test
	public void queSePuedaComprarSoloUnEquipo() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new Vendedor(1, 28.000, "Jose", 41728327);
		Equipo equipoVendido = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico planVendido = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, planVendido, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEquipo(equipoVendido);

		Venta nuevaVenta = new Venta(empresa.buscarVendedor(1), 10000.0, equipoVendido, nuevoCliente);

		Boolean va = empresa.agregarVenta(nuevaVenta);
		Boolean ve = true;

		assertEquals(ve, va);
	}
	
	@Test
	public void queSePuedaComprarSoloUnPlan() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new Vendedor(1, 28.000, "Jose", 41728327);
		Equipo equipoVendido = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico planVendido = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, planVendido, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarPlan(planVendido);

		Venta nuevaVenta = new Venta(empresa.buscarVendedor(1), planVendido, nuevoCliente);

		Boolean va = empresa.agregarVenta(nuevaVenta);
		Boolean ve = true;

		assertEquals(ve, va);
	}

	@Test
	public void queSePuedaAgregarUnEquipo() {
		Empresa empresa = new Empresa("sarasa");
		Equipo motorola = new Equipo("J7", 123, 40000.0);

		empresa.agregarEquipo(motorola);
		Integer valorEsperado = 1;
		Integer valorObtenido = empresa.getEquiposVigentes().size();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaEliminarUnEquipo() {
		Empresa empresa = new Empresa("sarasa");
		Equipo motorola = new Equipo("J7", 123, 40000.0);

		empresa.agregarEquipo(motorola);

		Integer valorEsperado = 0;
		empresa.eliminarEquipoViejo(123);
		Integer valorObtenido = empresa.getEquiposVigentes().size();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaBuscarUnEquipo() {
		Empresa empresa = new Empresa("sarasa");
		Equipo motorola = new Equipo("J7", 123, 40000.0);

		empresa.agregarEquipo(motorola);
		empresa.buscarEquipo(motorola);

		Equipo equipoEsperado = motorola;
		Equipo equipoObtenido = empresa.buscarEquipo(motorola);

		assertEquals(equipoEsperado, equipoObtenido);
	}

	@Test
	public void queSePuedaBuscarUnPlan() {

		Empresa empresa = new Empresa("sarasa");
		PlanTelefonico planEsperado = new PlanTelefonico(1000.0, 10, "Plan Basico");
		empresa.agregarPlan(planEsperado);
		PlanTelefonico PlanObtenido = empresa.buscarPlan(10);

		assertEquals(planEsperado, PlanObtenido);
	}

	@Test
	public void queSePuedaAgregarUnPlan() {
		Empresa empresa = new Empresa("sarasa");
		PlanTelefonico plan = new PlanTelefonico(1000.0, 10, "Plan Basico");
		empresa.agregarPlan(plan);
		Integer resultadoEsperado = 1;
		Integer resultadoObtenido = empresa.getPlanesVigentes().size();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queSePuedaEliminarUnPlan() {
		Empresa empresa = new Empresa("sarasa");
		PlanTelefonico plan = new PlanTelefonico(1000.0, 10, "Plan Basico");
		empresa.agregarPlan(plan);
		Integer resultadoEsperado = 0;
		empresa.eliminarPlan(10);
		Integer resultadoObtenido = empresa.getPlanesVigentes().size();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queSeCalculeBienElPorcentajeDeVenta() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new Vendedor(1, 30.0, "Jose", 41728327);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(1000.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);

		Venta nuevaVenta = new Venta(empresa.buscarVendedor(1), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		Double valorObtenido = empresa.buscarVendedor(1).getComision();
		Double ve = 500.0;

		assertEquals(ve, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnaConsulta() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		empresa.recepcionConsulta(100,"Consulta",nuevoCliente);
		
		Integer valorObtenido=empresa.getListaDeConsultas().size();
		Integer valorEsperado=1;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCambiarElPlan() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		PlanTelefonico planNuevo = new PlanTelefonico(200.0, 100, "PromoRaton");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		empresa.agregarPlan(planNuevo);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		empresa.cambiarPlanCliente(627285, 100);
		empresa.recepcionConsulta(100,"Consulta",nuevoCliente);
		
		PlanTelefonico valorObtenido=nuevoCliente.getPlanDelCliente();
		PlanTelefonico valorEsperado=planNuevo;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCambiarElEstadoDeLaConsulta() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		empresa.recepcionConsulta(100,"Consulta",nuevoCliente);
		empresa.cambiarEstadoConsulta(1,Estado.finalizado);
		
		Estado valorObtenido=empresa.buscarConsulta(1).getEstado();
		Estado valorEsperado=Estado.finalizado;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaBuscarConsultasPorCliente() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		empresa.recepcionConsulta(100,"Consulta",nuevoCliente);
		empresa.recepcionConsulta(100,"Consulta",nuevoCliente);
		
		Integer valorObtenido=empresa.buscarConsultaPorCliente(627285).size();
		Integer valorEsperado=2;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAsginarUnTecnico() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Empleado jose3 = new Tecnico("en la esquina", 200, 2.0,1,"jose3");
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEmpleado(jose3);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		empresa.recepcionConsulta(100,"sarasa",nuevoCliente,200,equipo);
		
		Tecnico valorObtenido=(Tecnico) empresa.buscarConsulta(1).getTecnico();
		Tecnico valorEsperado=(Tecnico) jose3;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAsginarUnVendedorAUnaVenta() {
		Empresa empresa = new Empresa("sarasa");
		Empleado jose = new AgenteDeServicio(100,100.0,"sarasa",400,true);
		Empleado jose2 = new Vendedor(101,100.0,"sarasa2",401);
		Equipo equipo = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico plan = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos", 40382237, 627285, plan, 1117272382);

		empresa.agregarEmpleado(jose);
		empresa.agregarEmpleado(jose2);
		empresa.agregarEquipo(equipo);
		empresa.agregarPlan(plan);
		Venta nuevaVenta = new Venta(empresa.buscarVendedor(101), equipo, plan, nuevoCliente);
		empresa.agregarVenta(nuevaVenta);
		
		Vendedor valorObtenido=(Vendedor) empresa.buscarVendedorPorVentaRealizada(1);
		Vendedor valorEsperado=(Vendedor) jose2;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	
	
}
