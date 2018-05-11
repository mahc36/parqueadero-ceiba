package co.com.ceiba.parqueadero.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.ITipoVehiculoManager;
import co.com.ceiba.parqueadero.service.ITipoVehiculoService;

public class TipoVehiculoManager implements ITipoVehiculoManager {

	@Autowired
	private ITipoVehiculoService  tipoVehiculoService;
	
	
	public TipoVehiculoManager() {
		super();
	}

	@Override
	public List<TipoVehiculo> traerTiposVehiculos() {
		return tipoVehiculoService.tiposVehiculos();
	}
}
