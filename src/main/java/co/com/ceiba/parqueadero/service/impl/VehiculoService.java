package co.com.ceiba.parqueadero.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.converter.FacturaConverter;
import co.com.ceiba.parqueadero.converter.VehiculoConverter;
import co.com.ceiba.parqueadero.entity.VehiculoEntity;
import co.com.ceiba.parqueadero.excepcion.IngresoExcepcion;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.repository.IVehiculoRepository;
import co.com.ceiba.parqueadero.service.IFacturaService;
import co.com.ceiba.parqueadero.service.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	@Autowired
	private IFacturaService facturaService;
	
	
	VehiculoConverter vehiculoConverter = new VehiculoConverter();
	FacturaConverter facturaConverter = new FacturaConverter();
	
	private static final String NO_PARQUEAR_DOMINGOS_NI_LUNES = "Las placas iniciadas en A no se pueden parquear los domingos y los lunes";
	private static final String VEHICULO_NO_PERMITIDO ="Solo se permiten motos y carros";
	private static final String VEHICULO_ESTA_PARQUEADO = "El vehículo ya se encuentra parqueado";
	private static final String MOTO="moto";
	private static final String CARRO="carro";
	
	public VehiculoService() {
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
	public boolean vehiculoSePermiteParquear(String tipoVehiculo) {
		boolean retorno = false;
		if(tipoVehiculo.equalsIgnoreCase(MOTO) || tipoVehiculo.equalsIgnoreCase(CARRO)) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	@Transactional
	public void parquear(Vehiculo vehiculoModel){
		Date fechaIngreso = new Date();
		if(this.vehiculoEstaParqueado(vehiculoModel.getPlaca())) {
			throw new IngresoExcepcion(VEHICULO_ESTA_PARQUEADO);
		}
		if(!this.permitirEntrada(vehiculoModel.getPlaca(),fechaIngreso)){
			throw new IngresoExcepcion(NO_PARQUEAR_DOMINGOS_NI_LUNES);
		}
		if(!this.vehiculoSePermiteParquear(vehiculoModel.getTipoVehiculo())) {
			throw new IngresoExcepcion(VEHICULO_NO_PERMITIDO);
		}
		
		//Agrega un vehiculo al parqueadero FALTA POR IMPLEMENTAR
		vehiculoModel.setEstado(true);
		VehiculoEntity vehiculoParqueado = vehiculoRepository.insertar(vehiculoConverter.convertirModel2Entity(vehiculoModel));
		
		facturaService.crearFactura(vehiculoConverter.convertirEntity2Model(vehiculoParqueado),fechaIngreso);
	}

	@Override
	public void sacarVehiculo(Vehiculo vehiculoModel) {

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
