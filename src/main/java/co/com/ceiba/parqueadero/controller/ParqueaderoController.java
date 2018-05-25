package co.com.ceiba.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.IVigilanteService;

@RestController
@RequestMapping(path = "/parqueadero")
@CrossOrigin(origins="http://localhost:4200")
public class ParqueaderoController{
	
	@Autowired
	private IVigilanteService vigilanteService;
	
	@RequestMapping(value="/parquear",method = RequestMethod.POST)
	public void parquearVehiculo(@RequestBody Vehiculo vehiculo) throws ParqueaderoExcepcion{
		vigilanteService.parquear(vehiculo);
	}
	
	@RequestMapping(value="/sacarvehiculo",method = RequestMethod.GET)
	public Factura sacarVehiculo(@RequestParam(value = "placa") String placa) throws ParqueaderoExcepcion{
		return vigilanteService.sacarVehiculo(placa);
	}
	
	
	@RequestMapping(value="/vehiculosparqueados",method= RequestMethod.GET)
	public List<Vehiculo> vehiculosParqueados(){
		return vigilanteService.vehiculosParqueados();
	}

	@RequestMapping(value="/facturasvehiculosactivos", method = RequestMethod.GET)
	public List<Factura> facturasVehiculosActivos(){
		return vigilanteService.facturasVehiculosActivos();
	}
}
