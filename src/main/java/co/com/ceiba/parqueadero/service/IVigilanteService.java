package co.com.ceiba.parqueadero.service;

import java.util.List;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.TipoVehiculo;
import co.com.ceiba.parqueadero.model.Vehiculo;

public interface IVigilanteService {

	void parquear(Vehiculo vehiculo);
	
	Factura sacarVehiculo(String placa);
	
	List<Vehiculo> vehiculosParqueados();

	List<TipoVehiculo> traerTiposVehiculos();
}
