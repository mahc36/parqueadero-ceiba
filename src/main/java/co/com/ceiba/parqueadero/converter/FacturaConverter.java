package co.com.ceiba.parqueadero.converter;

import co.com.ceiba.parqueadero.entity.FacturaEntity;
import co.com.ceiba.parqueadero.model.Factura;

public class FacturaConverter {
	
	VehiculoConverter vehiculoConverter = new VehiculoConverter();

	public FacturaConverter() {
		super();
	}
	
	public Factura convertirEntity2Model(FacturaEntity factura) {
		Factura facturaModel = new Factura();
		
		facturaModel.setId(factura.getId());
		facturaModel.setValorTotal(factura.getValorTotal());
		facturaModel.setFechaInicio(factura.getFechaInicio());
		facturaModel.setFechaFin(factura.getFechaFin());
		facturaModel.setVehiculoModel(vehiculoConverter.convertirEntity2Model(factura.getVehiculo()));
		
		return facturaModel;
	}
	
	public FacturaEntity convertirModel2Entity(Factura facturaModel) {
		FacturaEntity factura = new FacturaEntity();
		
		factura.setId(facturaModel.getId());
		factura.setValorTotal(facturaModel.getValorTotal());
		factura.setFechaInicio(facturaModel.getFechaInicio());
		factura.setFechaFin(facturaModel.getFechaFin());
		factura.setVehiculo(vehiculoConverter.convertirModel2Entity(facturaModel.getVehiculoModel()));
		
		return factura;
		
		
	}

}
