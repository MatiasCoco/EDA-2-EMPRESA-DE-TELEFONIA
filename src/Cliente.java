
public class Cliente extends Persona {

	private Integer numeroDeCliente;
	private PlanTelefonico planDelCliente; 
	private Integer numeroDeTelefono;
	
	public Cliente(String nombre, Integer dni, Integer numeroDeCliente, PlanTelefonico planDelCliente,
			Integer numeroDeTelefono) {
		super(nombre, dni);
		this.numeroDeCliente = numeroDeCliente;
		this.planDelCliente = planDelCliente;
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	
}
