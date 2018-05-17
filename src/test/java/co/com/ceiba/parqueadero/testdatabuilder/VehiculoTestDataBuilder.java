package co.com.ceiba.parqueadero.testdatabuilder;

import co.com.ceiba.parqueadero.model.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final int ID=132;
	private static final int CILINDRAJE = 200;
	private static final String PLACA = "USF02D";
	private static final String TIPO_VEHICULO = "moto";
	private static final boolean ESTADO = true;
	
	private int id;
	private int cilindraje;
	private String placa;
	private String tipoVehiculo;
	private boolean estado;
	
	public VehiculoTestDataBuilder() {
		super();
		this.id = ID;
		this.cilindraje=CILINDRAJE;
		this.placa = PLACA;
		this.tipoVehiculo=TIPO_VEHICULO;
		this.estado=ESTADO;
	}
	
	public VehiculoTestDataBuilder conId(int id){
		this.id=id;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje=cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa=placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	public VehiculoTestDataBuilder conEstado(boolean estado) {
		this.estado=estado;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.id,this.cilindraje,this.placa,this.tipoVehiculo,this.estado);
	}
}
