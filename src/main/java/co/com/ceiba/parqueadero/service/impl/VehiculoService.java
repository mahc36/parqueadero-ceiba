package co.com.ceiba.parqueadero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.entity.Vehiculo;
import co.com.ceiba.parqueadero.repository.VehiculoRepository;
import co.com.ceiba.parqueadero.service.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepository;
	
	public VehiculoService() {
		super();
	}
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}
}
