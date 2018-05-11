package co.com.ceiba.parqueadero.model;

import java.io.Serializable;

public class TipoVehiculoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TipoVehiculoModel() {
		super();
	}
	
	private int id;
	private String nombreTipo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
}
