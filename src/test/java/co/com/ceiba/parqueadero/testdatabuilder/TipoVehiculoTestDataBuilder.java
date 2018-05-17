package co.com.ceiba.parqueadero.testdatabuilder;

import co.com.ceiba.parqueadero.entity.TipoVehiculoEntity;

public class TipoVehiculoTestDataBuilder {
	
	private static final int ID= 1;
	private static final String NOMBRE_TIPO="moto";
	
	private int id;
	private String nombreTipo;

	public TipoVehiculoTestDataBuilder() {
		super();
		this.id = ID;
		this.nombreTipo= NOMBRE_TIPO;
	}
	
	public TipoVehiculoTestDataBuilder conId(int id) {
		this.id=id;
		return this;
	}
	
	public TipoVehiculoTestDataBuilder conNombreTipo(String nombreTipo) {
		this.nombreTipo=nombreTipo;
		return this;
	}
	
	public TipoVehiculoEntity build() {
		return new TipoVehiculoEntity(this.id,this.nombreTipo);
	}
	
}
