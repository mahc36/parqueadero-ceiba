package co.com.ceiba.parqueadero.repository;

import co.com.ceiba.parqueadero.model.Factura;

public interface IFacturaRepository {
	
	Factura agregarFactura(Factura factura);
	
	Factura findFacturaByVehiculoId(int vehiculoId);
	
	Factura actualizarFactura(Factura factura);
	
}
