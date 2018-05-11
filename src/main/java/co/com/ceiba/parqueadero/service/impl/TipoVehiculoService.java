package co.com.ceiba.parqueadero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.repository.TipoVehiculoRepository;
import co.com.ceiba.parqueadero.service.ITipoVehiculoService;

@Service
public class TipoVehiculoService implements ITipoVehiculoService{

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;
	
	
	public TipoVehiculoService() {
		super();
	}

	@Override
	public List<TipoVehiculo> tiposVehiculos() {
		return tipoVehiculoRepository.findAll();
	}

}
