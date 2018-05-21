package co.com.ceiba.parqueadero.service;

import java.util.Date;

public interface IVehiculoService {

	boolean permitirEntradaPlacaIniciadaA(String placa,Date fecha);
	
	boolean permitirParquearTipoVehiculo(String tipoVehiculo);
	
	boolean vehiculoEstaParqueado(String placa);
	
	boolean parqueaderoNoDisponible(String tipoVehiculo);
} 
