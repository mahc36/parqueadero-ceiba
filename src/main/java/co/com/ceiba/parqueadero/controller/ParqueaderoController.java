package co.com.ceiba.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.ITipoVehiculoManager;


@Controller
@RestController
public class ParqueaderoController {

	@Autowired
	private ITipoVehiculoManager tipoVehiculoManager;
	
	public ParqueaderoController() {
		super();
	}
	@GetMapping("/getTiposVehiculos")
	public List<TipoVehiculo> tiposVehiculos(){
		return tipoVehiculoManager.traerTiposVehiculos();
	}
}
