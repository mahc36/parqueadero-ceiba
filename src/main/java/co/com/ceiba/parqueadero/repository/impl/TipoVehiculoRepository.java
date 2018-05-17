package co.com.ceiba.parqueadero.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.TipoVehiculoConverter;
import co.com.ceiba.parqueadero.model.TipoVehiculo;
import co.com.ceiba.parqueadero.repository.ITipoVehiculoRepository;
import co.com.ceiba.parqueadero.repositoryjpa.TipoVehiculoRepositoryJPA;

@Service()
public class TipoVehiculoRepository implements ITipoVehiculoRepository{

	@Autowired
	private TipoVehiculoRepositoryJPA tipoVehiculoRepositoryJpa;
	
	TipoVehiculoConverter tipoVehiculoConverter = new TipoVehiculoConverter();

	
	
	public TipoVehiculoRepository() {
		super();
	}

	@Override
	public List<TipoVehiculo> tiposVehiculos() {
		return tipoVehiculoConverter.convertirListaEntity2Model(tipoVehiculoRepositoryJpa.findAll());
	}
}
