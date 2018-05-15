package co.com.ceiba.parqueadero.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.impl.TipoVehiculoManager;
import co.com.ceiba.parqueadero.manager.impl.VehiculoManager;
import co.com.ceiba.parqueadero.model.VehiculoModel;

@RestController
@RequestMapping(path = "/parqueadero")
public class ParqueaderoController{
	
	@Autowired
	private TipoVehiculoManager tipoVehiculoManager;
	@Autowired
	private VehiculoManager vehiculoManager;
	
	@GetMapping("/getTiposVehiculos")
	public List<TipoVehiculo> tiposVehiculos(){
		return tipoVehiculoManager.traerTiposVehiculos();
	}
	
	@RequestMapping(value="/parquear",method = RequestMethod.POST)
	public void parquearVehiculo(@RequestBody VehiculoModel vehiculoModel) throws ParseException {
		vehiculoManager.parquear(vehiculoModel);
	}
}
