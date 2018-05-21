package co.com.ceiba.parqueadero.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.FacturaConverter;
import co.com.ceiba.parqueadero.converter.VehiculoConverter;
import co.com.ceiba.parqueadero.repository.IVehiculoRepository;
import co.com.ceiba.parqueadero.service.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	VehiculoConverter vehiculoConverter = new VehiculoConverter();
	FacturaConverter facturaConverter = new FacturaConverter();
	
	private static final String MOTO="moto";
	private static final String CARRO="carro";
	private static final int MAX_MOTOS_PERMITIDAS = 10;
	private static final int MAX_CARROS_PERMITIDOS = 20;
	
	public VehiculoService() {
		super();
	}

	@Override
	public boolean permitirEntradaPlacaIniciadaA(String placa, Date fecha) {
		boolean retorno = true;
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		String primeraLetra = placa.substring(0,1);
		if(primeraLetra.equalsIgnoreCase("A") && (
				cal.get(Calendar.DAY_OF_WEEK)!=1 && cal.get(Calendar.DAY_OF_WEEK)!=2)){
			retorno = false;
		}
		return retorno;
	}
	
	@Override
	public boolean permitirParquearTipoVehiculo(String tipoVehiculo) {
		boolean retorno = false;
		if(tipoVehiculo.equalsIgnoreCase(MOTO) || tipoVehiculo.equalsIgnoreCase(CARRO)) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean parqueaderoNoDisponible(String tipoVehiculo) {
		if(tipoVehiculo.equalsIgnoreCase("moto")){
			int cantidadMotos = vehiculoRepository.cantidadMotoParqueadas();
			return MAX_MOTOS_PERMITIDAS>cantidadMotos?false:true;
		}
		else{
			int cantidadCarros = vehiculoRepository.cantidadCarrosParqueados();
			return MAX_CARROS_PERMITIDOS>cantidadCarros?false:true;
		}
	}

	@Override
	public boolean vehiculoEstaParqueado(String placa) {
		boolean retorno=false;
		if(vehiculoRepository.vehiculoEstaParqueado(placa) != null) {
			retorno = true;
		}
		return retorno;
	}
}
