package co.com.ceiba.parqueadero.manager;

import java.text.ParseException;
import java.util.Date;

import co.com.ceiba.parqueadero.model.VehiculoModel;

public interface IVehiculoManager {

	boolean permitirEntrada(String placa,Date fecha);
	
	void parquear(VehiculoModel vehiculoModel) throws ParseException;
} 
