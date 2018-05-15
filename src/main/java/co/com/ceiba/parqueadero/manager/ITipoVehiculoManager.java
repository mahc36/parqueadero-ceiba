package co.com.ceiba.parqueadero.manager;

import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;

public interface ITipoVehiculoManager {

	List<TipoVehiculo> traerTiposVehiculos();
	
	boolean permitirEntrada(String placa,Date fecha);
	
}
