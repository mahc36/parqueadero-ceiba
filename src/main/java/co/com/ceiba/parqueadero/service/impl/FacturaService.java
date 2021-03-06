package co.com.ceiba.parqueadero.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.FacturaConverter;
import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.repository.IFacturaRepository;
import co.com.ceiba.parqueadero.service.IFacturaService;

@Service
public class FacturaService implements IFacturaService {

	private static final int COSTO_HORA_MOTO = 500;
	private static final int COSTO_DIA_MOTO = 4000;
	private static final int COSTO_HORA_CARRO = 1000;
	private static final int COSTO_DIA_CARRO = 8000;
	private static final int CILINDRAJE_LIMITE = 500;
	private static final int VALOR_EXTRA = 2000;
	private static final int HORAS_COMIENZO_DIA = 9;
	private static final int HORAS_FIN_DIA = 24;
	private static final String MOTO = "moto";
	private static final String CARRO = "carro";
	
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	FacturaConverter facturaConverter = new FacturaConverter();
	
	
	public FacturaService() {
		super();
	}

	@Override
	public void crearFactura(Vehiculo vehiculo,Date fechaIngreso) {
		Factura factura = new Factura();
		factura.setFechaInicio(fechaIngreso);
		factura.setVehiculoModel(vehiculo);
		facturaRepository.agregarFactura(factura);
	}
	
	@Override
	public Date crearFecha(int anio, int mes, int dia, int hora, int minutos, int segundos) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes-1);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, minutos);
        cal.set(Calendar.SECOND, segundos);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}
	
	@Override
	public int calcularCostoParqueada(int horas,int valorHora,int valorDia) {
		int valorTotal = 0;
		if (horas < HORAS_COMIENZO_DIA) {
			valorTotal = valorHora * horas;
		}else {
			int dias = horas / HORAS_FIN_DIA;
			if (horas % HORAS_FIN_DIA == 0) {
				valorTotal = valorDia * dias;
			} else {
				valorTotal = (valorDia * dias);
				if ((horas - (dias * HORAS_FIN_DIA)) < HORAS_COMIENZO_DIA) {
					valorTotal = valorTotal + ((horas - (dias * HORAS_FIN_DIA)) * valorHora);
				} else {
					valorTotal = valorTotal + valorDia;
				}
			}
		}
		return valorTotal;
	}
	
	@Override
	public int tiempoParqueado(Date fechaIngreso, Date fechaSalida) {
		final int MILISEGUNDOS_A_HORA = 1000 * 60 * 60;
		float retorno = (fechaSalida.getTime() - fechaIngreso.getTime());
		retorno /= MILISEGUNDOS_A_HORA; 
		return (int) Math.ceil(retorno);
	}
	
	@Override
	public Factura calcularValorTotalParqueada(Factura factura,Vehiculo vehiculo) {
		int valorTotal = 0;
		int horasParqueadas = this.tiempoParqueado(factura.getFechaInicio(), factura.getFechaFin());
		if(vehiculo.getTipoVehiculo().equalsIgnoreCase(MOTO)){
			valorTotal = this.calcularCostoParqueada(horasParqueadas, COSTO_HORA_MOTO, COSTO_DIA_MOTO);
			int cilindraje = vehiculo.getCilindraje();
			valorTotal = cilindraje>CILINDRAJE_LIMITE ? valorTotal + VALOR_EXTRA : valorTotal;
		}else if(vehiculo.getTipoVehiculo().equalsIgnoreCase(CARRO)) {
			valorTotal = this.calcularCostoParqueada(horasParqueadas, COSTO_HORA_CARRO, COSTO_DIA_CARRO);
		}
		factura.setValorTotal(valorTotal);
		return factura;
	}

	@Override
	public Factura findFacturaByVehiculoId(int vehiculoId) {
		return facturaRepository.findFacturaByVehiculoId(vehiculoId);
	}

	@Override
	public Factura actualizarFactura(Factura factura) {
		return facturaRepository.actualizarFactura(factura);
	}
}
