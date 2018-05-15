package co.com.ceiba.parqueadero.model;

import java.io.Serializable;
import java.util.Date;

public class FacturaModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int valor;
	private Date fechaInicio;
	private Date fechaFin;
	private VehiculoModel vehiculoModel;

	public FacturaModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public VehiculoModel getVehiculoModel() {
		return vehiculoModel;
	}

	public void setVehiculoModel(VehiculoModel vehiculoModel) {
		this.vehiculoModel = vehiculoModel;
	}
}
