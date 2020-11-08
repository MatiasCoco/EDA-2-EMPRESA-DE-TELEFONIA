import static org.junit.Assert.*;

import org.junit.Test;

public class tests {
	
	@Test
	public void queSePuedaCrearUnaEmpresa() {
		Empresa empresa= new Empresa("sarasa");
		
		String va = empresa.getNombreDeLaEmpresa();
		String ve = "sarasa";
		
		assertEquals(ve, va);
	}

	@Test
	public void queSePuedaAgregarUnEmpleado() {

		Empresa empresa = new Empresa ("sarasa");
		Empleado matias = new Tecnico("Zona 1", 1, 123, 50.0, 4175758, "Matias");

		Boolean ve = empresa.agregarEmpleado(matias);
		Boolean va = true;

		assertEquals(ve, va);
	}

	
	@Test
	public void queSePuedaBuscarUnVendedor() {
		Empresa empresa = new Empresa ("sarasa");
		Empleado jose = new Vendedor(1, 28000.0, "Jose", 41728327);
		
		empresa.agregarEmpleado(jose);
		
		Vendedor va = empresa.buscarVendedor(1);
		
		assertEquals(jose, va);
	}
	
	@Test
	public void queSePuedaAgregarUnaVenta() {
		Empresa empresa = new Empresa ("sarasa");
		Empleado jose = new Vendedor(1, 28.000, "Jose", 41728327);
		Equipo equipoVendido = new Equipo("Lg K1", 7383, 9000.0);
		PlanTelefonico planVendido = new PlanTelefonico(900.0, 4, "SuperPromo");
		Cliente nuevoCliente = new Cliente("Carlos",40382237, 627285, planVendido, 1117272382);
		
		empresa.agregarEmpleado(jose);
		empresa.agregarEquipo(equipoVendido);
		empresa.agregarPlan(planVendido);
		
		Venta nuevaVenta = new Venta(143, empresa.buscarVendedor(1), 10000.0, equipoVendido, planVendido, nuevoCliente);
		
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
		Integer resultadoEsperado=1;
		Integer resultadoObtenido=empresa.getPlanesVigentes().size();
	
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void queSePuedaEliminarUnPlan() {
		Empresa empresa = new Empresa("sarasa");
		PlanTelefonico plan = new PlanTelefonico(1000.0, 10, "Plan Basico");
		empresa.agregarPlan(plan);
		Integer resultadoEsperado=0;
		empresa.eliminarPlan(10);
		Integer resultadoObtenido=empresa.getPlanesVigentes().size();
		
		assertEquals(resultadoEsperado, resultadoObtenido);	
	}
	
	
}
