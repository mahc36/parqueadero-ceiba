package co.com.ceiba.parqueadero.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.FacturaConverter;
import co.com.ceiba.parqueadero.entity.FacturaEntity;
import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.repository.IFacturaRepository;
import co.com.ceiba.parqueadero.repositoryjpa.FacturaRepositoryJPA;

@Service
public class FacturaRepository implements IFacturaRepository{
	
	@Autowired
	private FacturaRepositoryJPA facturaRepositoryJpa;
	FacturaConverter facturaConverter = new FacturaConverter();
	
	public FacturaRepository() {
		super();
	}

	@Override
	public Factura agregarFactura(Factura factura) {
		FacturaEntity facturaEntity = facturaConverter.convertirModel2Entity(factura);
		return facturaConverter.convertirEntity2Model(facturaRepositoryJpa.save(facturaEntity));
	}

	@Override
	public Factura findFacturaByVehiculoId(int vehiculoId) {
		return facturaConverter.convertirEntity2Model(facturaRepositoryJpa.findByVehiculoId(vehiculoId));
	}

	@Override
	public void actualizarFactura(Factura factura) {
		facturaRepositoryJpa.save(facturaConverter.convertirModel2Entity(factura));
	}
}
