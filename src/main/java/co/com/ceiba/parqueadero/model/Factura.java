package co.com.ceiba.parqueadero.model;

import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int valorTotal;
	private Date fechaInicio;
	private Date fechaFin;
	private Vehiculo vehiculoModel;

	public Factura() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
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

	public Vehiculo getVehiculoModel() {
		return vehiculoModel;
	}

	public void setVehiculoModel(Vehiculo vehiculoModel) {
		this.vehiculoModel = vehiculoModel;
	}
}
