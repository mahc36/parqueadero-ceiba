package co.com.ceiba.parqueadero.model;

import java.io.Serializable;


public class Vehiculo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cilindraje;
	private String placa;
	private String tipoVehiculo;
	private boolean estado;
	
	public Vehiculo() {
		super();
	}
	
	public Vehiculo(int id, int cilindraje, String placa, String tipoVehiculo, boolean estado) {
		super();
		this.id = id;
		this.cilindraje = cilindraje;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
