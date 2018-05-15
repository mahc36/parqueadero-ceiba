package co.com.ceiba.parqueadero.converter;

import co.com.ceiba.parqueadero.entity.Vehiculo;
import co.com.ceiba.parqueadero.model.VehiculoModel;

public class VehiculoConverter {

	public VehiculoConverter() {
		super();
	}
	
	public VehiculoModel convertirEntity2Model(Vehiculo vehiculo){
		VehiculoModel vehiculoModel = new VehiculoModel();
		
		vehiculoModel.setId(vehiculo.getId());
		vehiculoModel.setPlaca(vehiculo.getPlaca());
		vehiculoModel.setCilindraje(vehiculo.getCilindraje());
		vehiculoModel.setTipoVehiculo(vehiculo.getTipoVehiculo());
		
		return vehiculoModel;
	}
	
	public Vehiculo convertirModel2Entity(VehiculoModel vehiculoModel) {
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setId(vehiculoModel.getId());
		vehiculo.setPlaca(vehiculoModel.getPlaca());
		vehiculo.setCilindraje(vehiculoModel.getCilindraje());
		vehiculo.setTipoVehiculo(vehiculoModel.getTipoVehiculo());
		
		return vehiculo;
	}
	

}
