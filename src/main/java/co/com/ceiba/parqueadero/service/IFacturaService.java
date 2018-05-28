package co.com.ceiba.parqueadero.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;

@Service
public interface IFacturaService {

	void crearFactura(Vehiculo vehiculo,Date fechaIngreso);
	
	Date crearFecha(int anio, int mes, int dia, int hora, int minutos, int segundos);
	
	int calcularCostoParqueada(int horas,int valorHora,int valorDia);
	
	int tiempoParqueado(Date fechaIngreso, Date fechaSalida);
	
	Factura calcularValorTotalParqueada(Factura factura, Vehiculo vehiculo);
	
	Factura findFacturaByVehiculoId(int vehiculoId);
	
	Factura actualizarFactura(Factura factura);
	
}
