package co.com.ceiba.parqueadero.model;

import java.io.Serializable;


public class VehiculoModel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cilindraje;
	private String placa;
	private FacturaModel facturaModel;
	private TipoVehiculoModel tipoVehiculoModel;
	
	public VehiculoModel() {
		super();
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

	public FacturaModel getFacturaModel() {
		return facturaModel;
	}

	public void setFacturaModel(FacturaModel facturaModel) {
		this.facturaModel = facturaModel;
	}

	public TipoVehiculoModel getTipoVehiculoModel() {
		return tipoVehiculoModel;
	}

	public void setTipoVehiculoModel(TipoVehiculoModel tipoVehiculoModel) {
		this.tipoVehiculoModel = tipoVehiculoModel;
	}
}
