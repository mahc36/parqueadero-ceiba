package co.com.ceiba.parqueadero.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;

@Service
public interface IFacturaService {

	void facturar(Factura factura);
	
	void crearFactura(Vehiculo vehiculo,Date fechaIngreso);
	
	int calcularValorTotalParqueada(Date fechaIngreso, Date fechaSalida, Vehiculo vehiculo);
	
}
