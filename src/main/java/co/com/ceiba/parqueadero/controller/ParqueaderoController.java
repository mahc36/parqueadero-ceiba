package co.com.ceiba.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.model.TipoVehiculo;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.ITipoVehiculoService;
import co.com.ceiba.parqueadero.service.IVehiculoService;

@RestController
@RequestMapping(path = "/parqueadero")
public class ParqueaderoController{
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/getTiposVehiculos")
	public List<TipoVehiculo> tiposVehiculos(){
		return tipoVehiculoService.traerTiposVehiculos();
	}
	
	@RequestMapping(value="/parquear",method = RequestMethod.POST)
	public void parquearVehiculo(@RequestBody Vehiculo vehiculo){
		vehiculoService.parquear(vehiculo);
	}
}
