package co.com.ceiba.parqueadero.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;

@Service
public interface IFacturaService {

	void crearFactura(Vehiculo vehiculo,Date fechaIngreso);
	
	Factura calcularValorTotalParqueada(Factura factura, Vehiculo vehiculo);
	
	Factura findFacturaByVehiculoId(int vehiculoId);
	
	Factura actualizarFactura(Factura factura);
	
}
