package co.com.ceiba.parqueadero.model;

import java.io.Serializable;

public class ParqueaderoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidadCarros;
	private int cantidadMotos;
	
	public ParqueaderoModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadCarros() {
		return cantidadCarros;
	}

	public void setCantidadCarros(int cantidadCarros) {
		this.cantidadCarros = cantidadCarros;
	}

	public int getCantidadMotos() {
		return cantidadMotos;
	}

	public void setCantidadMotos(int cantidadMotos) {
		this.cantidadMotos = cantidadMotos;
	}
}
