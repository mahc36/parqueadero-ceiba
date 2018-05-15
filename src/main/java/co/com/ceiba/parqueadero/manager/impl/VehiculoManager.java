package co.com.ceiba.parqueadero.manager.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.VehiculoConverter;
import co.com.ceiba.parqueadero.excepcion.IngresoExcepcion;
import co.com.ceiba.parqueadero.manager.IVehiculoManager;
import co.com.ceiba.parqueadero.model.VehiculoModel;
import co.com.ceiba.parqueadero.service.IVehiculoService;

@Service
public class VehiculoManager implements IVehiculoManager{

	@Autowired
	private IVehiculoService vehiculoService;
	VehiculoConverter vehiculoConverter = new VehiculoConverter();
	
	
	
	private static final String NO_PARQUEAR_DOMINGOS_NI_LUNES = "Las placas iniciadas en A no se pueden parquear los domingos y los lunes";

	public VehiculoManager() {
		super();
	}

	@Override
	public boolean permitirEntrada(String placa, Date fecha) {
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

	@Override
	public void parquear(VehiculoModel vehiculoModel) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		if(!this.permitirEntrada(vehiculoModel.getPlaca(), fechaSolicitud)){
			throw new IngresoExcepcion(NO_PARQUEAR_DOMINGOS_NI_LUNES);
		}
		vehiculoService.insertar(vehiculoConverter.convertirModel2Entity(vehiculoModel));
	}
}
