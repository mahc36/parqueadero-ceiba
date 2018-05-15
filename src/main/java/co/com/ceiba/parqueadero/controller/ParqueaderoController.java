package co.com.ceiba.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.impl.TipoVehiculoManager;

@RestController
@RequestMapping(path = "/parqueadero")
public class ParqueaderoController{
	
	@Autowired
	private TipoVehiculoManager tipoVehiculoManager;	
	
	@GetMapping("/getTiposVehiculos")
	public List<TipoVehiculo> tiposVehiculos(){
		return tipoVehiculoManager.traerTiposVehiculos();
	}

}
