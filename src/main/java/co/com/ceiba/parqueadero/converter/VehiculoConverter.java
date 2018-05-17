package co.com.ceiba.parqueadero.converter;

import co.com.ceiba.parqueadero.entity.VehiculoEntity;
import co.com.ceiba.parqueadero.model.Vehiculo;

public class VehiculoConverter {

	public VehiculoConverter() {
		super();
	}
	
	public Vehiculo convertirEntity2Model(VehiculoEntity vehiculo){
		Vehiculo vehiculoModel = new Vehiculo();
		
		vehiculoModel.setId(vehiculo.getId());
		vehiculoModel.setPlaca(vehiculo.getPlaca());
		vehiculoModel.setCilindraje(vehiculo.getCilindraje());
		vehiculoModel.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoModel.setEstado(vehiculo.isEstado());
		
		return vehiculoModel;
	}
	
	public VehiculoEntity convertirModel2Entity(Vehiculo vehiculoModel) {
		VehiculoEntity vehiculo = new VehiculoEntity();
		
		vehiculo.setId(vehiculoModel.getId());
		vehiculo.setPlaca(vehiculoModel.getPlaca());
		vehiculo.setCilindraje(vehiculoModel.getCilindraje());
		vehiculo.setTipoVehiculo(vehiculoModel.getTipoVehiculo());
		vehiculo.setEstado(vehiculoModel.isEstado());
		
		return vehiculo;
	}
}
