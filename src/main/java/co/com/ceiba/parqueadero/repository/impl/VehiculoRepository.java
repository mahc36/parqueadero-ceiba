package co.com.ceiba.parqueadero.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.entity.VehiculoEntity;
import co.com.ceiba.parqueadero.repository.IVehiculoRepository;
import co.com.ceiba.parqueadero.repositoryjpa.VehiculoRepositoryJPA;

@Service
public class VehiculoRepository implements IVehiculoRepository {

	@Autowired
	VehiculoRepositoryJPA vehiculoRepository;
	
	public VehiculoRepository() {
		super();
	}
	
	@Override
	public VehiculoEntity insertar(VehiculoEntity vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	@Override
	public VehiculoEntity vehiculoEstaParqueado(String placa) {
		return vehiculoRepository.findByPlaca(placa); 
	}

	@Override
	public VehiculoEntity findById(int id) {
		return vehiculoRepository.findById(id);
	}

	@Override
	public VehiculoEntity actualizarVehiculo(VehiculoEntity vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
}
