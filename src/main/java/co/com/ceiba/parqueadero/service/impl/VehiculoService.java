package co.com.ceiba.parqueadero.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.converter.FacturaConverter;
import co.com.ceiba.parqueadero.converter.VehiculoConverter;
import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Factura;
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
	private static final String VEHICULO_NO_ESTA_PARQUEADO = "El vehículo no se encuentra parqueado";
	private static final String NO_HAY_CELDAS_DISPONIBLES = "Lo sentimos, no hay celdas disponibles";
	private static final String MOTO="moto";
	private static final String CARRO="carro";
	private static final int MAX_MOTOS_PERMITIDAS = 10;
	private static final int MAX_CARROS_PERMITIDOS = 20;
	
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
	public boolean permitirParquearTipoVehiculo(String tipoVehiculo) {
		boolean retorno = false;
		if(tipoVehiculo.equalsIgnoreCase(MOTO) || tipoVehiculo.equalsIgnoreCase(CARRO)) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	@Transactional
	public void parquear(Vehiculo vehiculo){
		Date fechaIngreso = new Date();
		if(!this.permitirParquearTipoVehiculo(vehiculo.getTipoVehiculo())) {
			throw new ParqueaderoExcepcion(VEHICULO_NO_PERMITIDO);
		}
		if(!this.permitirEntrada(vehiculo.getPlaca(),fechaIngreso)){
			throw new ParqueaderoExcepcion(NO_PARQUEAR_DOMINGOS_NI_LUNES);
		}
		if(this.vehiculoEstaParqueado(vehiculo.getPlaca())) {
			throw new ParqueaderoExcepcion(VEHICULO_ESTA_PARQUEADO);
		}
		if(this.parqueaderoNoDisponible(vehiculo.getTipoVehiculo())){
			throw new ParqueaderoExcepcion(NO_HAY_CELDAS_DISPONIBLES);
		}
		vehiculo.setEstado(true);
		Vehiculo vehiculoParqueado = vehiculoRepository.agregarAlParqueadero(vehiculo) ;
		facturaService.crearFactura(vehiculoParqueado,fechaIngreso);
	}

	private boolean parqueaderoNoDisponible(String tipoVehiculo) {
		if(tipoVehiculo.equalsIgnoreCase("moto")){
			int cantidadMotos = vehiculoRepository.cantidadMotoParqueadas();
			return MAX_MOTOS_PERMITIDAS<cantidadMotos?false:true;
		}
		else{
			int cantidadCarros = vehiculoRepository.cantidadCarrosParqueados();
			return MAX_CARROS_PERMITIDOS<cantidadCarros?false:true;
		}
	}

	@Override
	@Transactional
	public void sacarVehiculo(String placa) {
		if(!this.vehiculoEstaParqueado(placa)) {
			throw new ParqueaderoExcepcion(VEHICULO_NO_ESTA_PARQUEADO);
		}
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		Factura factura = facturaService.findFacturaByVehiculoId(vehiculo.getId());
		factura = facturaService.calcularValorTotalParqueada(factura, vehiculo);
		facturaService.actualizarFactura(factura);
		vehiculo.setEstado(false);
		vehiculoRepository.actualizarVehiculo(vehiculo);
	}

	@Override
	public boolean vehiculoEstaParqueado(String placa) {
		boolean retorno=false;
		if(vehiculoRepository.vehiculoEstaParqueado(placa) != null) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public List<Vehiculo> vehiculosParqueados() {
		return vehiculoRepository.vehiculosParqueados();
	}
}
