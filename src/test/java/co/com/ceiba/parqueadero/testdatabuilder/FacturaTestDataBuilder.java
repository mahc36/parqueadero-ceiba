package co.com.ceiba.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;

public class FacturaTestDataBuilder {

	private static final int ID=132;
	private static final int VALOR_TOTAL=0;
	private static final Date FECHA_INICIO = new Date();
	private static final Date FECHA_FIN = null;
	private static final Vehiculo VEHICULO=null;
	
	private int id;
	private int valorTotal;
	private Date fechaInicio;
	private Date fechaFin;
	private Vehiculo vehiculo;
	
	public FacturaTestDataBuilder() {
		super();
		this.id=ID;
		this.valorTotal=VALOR_TOTAL;
		this.fechaInicio=FECHA_INICIO;
		this.fechaFin=FECHA_FIN;
		this.vehiculo=VEHICULO;
	}
	
	public FacturaTestDataBuilder conId(int id) {
		this.id = id;
		return this;
	}
	
	public FacturaTestDataBuilder conValorTotal(int valorTotal) {
		this.valorTotal=valorTotal;
		return this;
	}
	
	public FacturaTestDataBuilder conFechaInicio(Date fechaInicio) {
		this.fechaInicio=fechaInicio;
		return this;
	}

	public FacturaTestDataBuilder conFechaFin(Date fechaFin) {
		this.fechaFin=fechaFin;
		return this;
	}
	
	public FacturaTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		return this;
	}
	
	public Factura build() {
		return new Factura(this.id, this.valorTotal, this.fechaInicio, this.fechaFin, this.vehiculo);
	}
}
