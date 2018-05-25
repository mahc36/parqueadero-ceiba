package co.com.ceiba.parqueadero.service;

import java.util.List;

import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;

public interface IVigilanteService {

	Vehiculo parquear(Vehiculo vehiculo) throws ParqueaderoExcepcion;
	
	Factura sacarVehiculo(String placa) throws ParqueaderoExcepcion;
	
	List<Vehiculo> vehiculosParqueados();
	
	List <Factura> facturasVehiculosActivos();
	
}
