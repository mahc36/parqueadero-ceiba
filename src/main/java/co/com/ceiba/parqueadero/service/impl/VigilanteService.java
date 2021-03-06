package co.com.ceiba.parqueadero.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.repository.IFacturaRepository;
import co.com.ceiba.parqueadero.repository.IVehiculoRepository;
import co.com.ceiba.parqueadero.service.IFacturaService;
import co.com.ceiba.parqueadero.service.IVehiculoService;
import co.com.ceiba.parqueadero.service.IVigilanteService;

@Service
public class VigilanteService implements IVigilanteService{

	@Autowired
	IVehiculoService vehiculoService;
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	@Autowired
	private IFacturaRepository facturaRepository;
	
	private static final String PARQUEAR_SOLO_DOMINGOS_Y_LUNES = "Las placas iniciadas en A solo se pueden parquear los Domingos y los Lunes";
	private static final String VEHICULO_NO_PERMITIDO ="Solo se permiten motos y carros";
	private static final String VEHICULO_ESTA_PARQUEADO = "El veh�culo ya se encuentra parqueado";
	private static final String VEHICULO_NO_ESTA_PARQUEADO = "El veh�culo no se encuentra parqueado";
	private static final String NO_HAY_CELDAS_DISPONIBLES = "Lo sentimos, no hay celdas disponibles";
	
	public VigilanteService() {
		super();
	}

	@Override
	@Transactional
	public Vehiculo parquear(Vehiculo vehiculo,Date fechaIngreso) throws ParqueaderoExcepcion {
		if(!vehiculoService.permitirParquearTipoVehiculo(vehiculo.getTipoVehiculo())) {
			throw new ParqueaderoExcepcion(VEHICULO_NO_PERMITIDO);
		}
		if(!vehiculoService.permitirEntradaPlacaIniciadaA(vehiculo.getPlaca(),fechaIngreso)){
			throw new ParqueaderoExcepcion(PARQUEAR_SOLO_DOMINGOS_Y_LUNES);
		}
		if(vehiculoService.vehiculoEstaParqueado(vehiculo.getPlaca())) {
			throw new ParqueaderoExcepcion(VEHICULO_ESTA_PARQUEADO);
		}
		if(vehiculoService.parqueaderoNoDisponible(vehiculo.getTipoVehiculo())){
			throw new ParqueaderoExcepcion(NO_HAY_CELDAS_DISPONIBLES);
		}
		vehiculo.setEstado(true);
		Vehiculo vehiculoParqueado = vehiculoRepository.agregarAlParqueadero(vehiculo) ;
		facturaService.crearFactura(vehiculoParqueado,fechaIngreso);
		return vehiculoParqueado;
	}

	@Override
	@Transactional
	public Factura sacarVehiculo(String placa) throws ParqueaderoExcepcion {
		if(!vehiculoService.vehiculoEstaParqueado(placa)) {
			throw new ParqueaderoExcepcion(VEHICULO_NO_ESTA_PARQUEADO);
		}
		Vehiculo vehiculo = vehiculoRepository.vehiculoEstaParqueado(placa);
		Factura factura = facturaService.findFacturaByVehiculoId(vehiculo.getId());
		factura.setFechaFin(new Date());
		factura = facturaService.calcularValorTotalParqueada(factura, vehiculo);
		vehiculo.setEstado(false);
		vehiculoRepository.actualizarVehiculo(vehiculo);
		factura = facturaService.actualizarFactura(factura);
		return factura;
	}

	@Override
	public List<Vehiculo> vehiculosParqueados() {
		return vehiculoRepository.vehiculosParqueados();
	}

	@Override
	public List<Factura> facturasVehiculosActivos() {
		return facturaRepository.facturasVehiculosActivos();
	}
}
