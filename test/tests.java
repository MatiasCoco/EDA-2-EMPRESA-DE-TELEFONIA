import static org.junit.Assert.*;

import org.junit.Test;

public class tests {

	@Test
	public void queSePuedaAgregarUnEmpleado() {
		
		Empresa empresa = new Empresa ("sarasa");
		
		Empleado matias = new Tecnico("Zona 1", 1, 123, 50.0, 4175758, "Hernan");
		
		Boolean ve = empresa.agregarEmpleado(matias);
		Boolean va = true;
		
		assertEquals(ve, va);
	}

}
