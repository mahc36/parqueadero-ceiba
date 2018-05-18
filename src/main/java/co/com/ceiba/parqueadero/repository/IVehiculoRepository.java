package co.com.ceiba.parqueadero.repository;

import java.util.List;

import co.com.ceiba.parqueadero.model.Vehiculo;

public interface IVehiculoRepository {

	Vehiculo agregarAlParqueadero(Vehiculo vehiculo);
	
	Vehiculo vehiculoEstaParqueado(String placa);
	
	Vehiculo findById(int id);
	
	Vehiculo findByPlaca(String placa);
	
	Vehiculo actualizarVehiculo(Vehiculo vehiculo);	
	
	List<Vehiculo> vehiculosParqueados();
	
	int cantidadMotoParqueadas();
	
	int cantidadCarrosParqueados();
}
