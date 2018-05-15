package co.com.ceiba.parqueadero.manager.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.ITipoVehiculoManager;
import co.com.ceiba.parqueadero.service.ITipoVehiculoService;

@Service
public class TipoVehiculoManager implements ITipoVehiculoManager {

	@Autowired
	private ITipoVehiculoService  tipoVehiculoService;
	
	
	public TipoVehiculoManager() {
		super();
	}
	
	@Override
	public List<TipoVehiculo> traerTiposVehiculos() {
		return tipoVehiculoService.tiposVehiculos();
	}

	@Override
	public boolean permitirEntrada(String placa,Date fecha) {
		boolean retorno = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		String primeraLetra = placa.substring(0,1);
		if(primeraLetra.equalsIgnoreCase("A")){
			if(cal.get(Calendar.DAY_OF_WEEK)!=1 && cal.get(Calendar.DAY_OF_WEEK)!=2){
				retorno = true;
			}
		}
		else {
			retorno = true;
		}
		return retorno;
	}
}
