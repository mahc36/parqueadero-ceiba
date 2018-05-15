package co.com.ceiba.parqueadero.converter;

import co.com.ceiba.parqueadero.entity.Factura;
import co.com.ceiba.parqueadero.model.FacturaModel;

public class FacturaConverter {
	
	VehiculoConverter vehiculoConverter = new VehiculoConverter();

	public FacturaConverter() {
		super();
	}
	
	public FacturaModel convertirEntity2Model(Factura factura) {
		FacturaModel facturaModel = new FacturaModel();
		
		facturaModel.setId(factura.getId());
		facturaModel.setValor(factura.getValor());
		facturaModel.setFechaInicio(factura.getFechaInicio());
		facturaModel.setFechaFin(factura.getFechaFin());
		facturaModel.setVehiculoModel(vehiculoConverter.convertirEntity2Model(factura.getVehiculo()));
		
		return facturaModel;
	}
	
	public Factura convertirModel2Entity(FacturaModel facturaModel) {
		Factura factura = new Factura();
		
		factura.setId(facturaModel.getId());
		factura.setValor(facturaModel.getValor());
		factura.setFechaInicio(facturaModel.getFechaInicio());
		factura.setFechaFin(facturaModel.getFechaFin());
		factura.setVehiculo(vehiculoConverter.convertirModel2Entity(facturaModel.getVehiculoModel()));
		
		return factura;
		
		
	}

}
