package co.com.ceiba.parqueadero.service;

import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.model.Vehiculo;

public interface IVehiculoService {

	boolean permitirEntrada(String placa,Date fecha);
	
	boolean permitirParquearTipoVehiculo(String tipoVehiculo);
	
	void parquear(Vehiculo vehiculo);
	
	void sacarVehiculo(String placa);
	
	boolean vehiculoEstaParqueado(String placa);
	
	List<Vehiculo> vehiculosParqueados();
} 
