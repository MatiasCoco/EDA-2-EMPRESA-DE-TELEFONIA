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
		
		empresa.agregarEmpleado(jose);
		empresa.agregarEquipo(equipoVendido);
		empresa.agregarPlanTelefonico(planVendido);
		
		Venta nuevaVenta = new Venta(143, empresa.buscarVendedor(1), 10000.0, equipoVendido, planVendido);
		
		Boolean va = empresa.agregarVenta(nuevaVenta);
		Boolean ve = true;
		
		assertEquals(ve, va);
	}
}
