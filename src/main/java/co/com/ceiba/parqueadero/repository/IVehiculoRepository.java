package co.com.ceiba.parqueadero.repository;

import co.com.ceiba.parqueadero.entity.VehiculoEntity;

public interface IVehiculoRepository {

	VehiculoEntity insertar(VehiculoEntity vehiculo);
	
	VehiculoEntity vehiculoEstaParqueado(String placa);
	
	VehiculoEntity findById(int id);
	
	VehiculoEntity actualizarVehiculo(VehiculoEntity vehiculo);
}
