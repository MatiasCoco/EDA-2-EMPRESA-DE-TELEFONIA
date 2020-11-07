import static org.junit.Assert.*;

import org.junit.Test;

public class tests {

	@Test
	public void queSePuedaAgregarUnEmpleado() {

		Empresa empresa = new Empresa("sarasa");

		Empleado matias = new Tecnico("Zona 1", 1, 123, 50.0, 4175758, "Hernan");

		Boolean ve = empresa.agregarEmpleado(matias);
		Boolean va = true;

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
