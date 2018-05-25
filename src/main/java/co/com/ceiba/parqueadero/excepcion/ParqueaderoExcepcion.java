package co.com.ceiba.parqueadero.excepcion;

public class ParqueaderoExcepcion extends Exception{

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public ParqueaderoExcepcion(String mensaje,Exception e) {
		super(e.getMessage(),e);
		this.mensaje=mensaje;
	}
	
	public ParqueaderoExcepcion(String mensaje) {
		super(mensaje);
		this.mensaje=mensaje;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
}
