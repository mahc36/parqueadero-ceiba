package co.com.ceiba.parqueadero.service;

import java.util.Date;

import co.com.ceiba.parqueadero.model.Vehiculo;

public interface IVehiculoService {

	boolean permitirEntrada(String placa,Date fecha);
	
	boolean vehiculoSePermiteParquear(String tipoVehiculo);
	
	void parquear(Vehiculo vehiculoModel);
	
	void sacarVehiculo(Vehiculo vehiculoModel);
	
	boolean vehiculoEstaParqueado(String placa);
} 
