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
	
	public int calcularCostoParqueada(int horas,int valorHora,int valorDia) {
		int valorTotal = 0;
		if (horas < 9) {
			valorTotal = valorHora * horas;
		}else {
			int dias = horas / 24;
			if (horas % 24 == 0) {
				valorTotal = valorDia * dias;
			} else {
				valorTotal = (valorDia * dias);
				if ((horas - (dias * 24)) < 9) {
					valorTotal = valorTotal + ((horas - (dias * 24)) * valorHora);
				} else {
					valorTotal = valorTotal + valorDia;
				}
			}
		}
		return valorTotal;
	}
	
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
		if(vehiculo.getTipoVehiculo().equalsIgnoreCase("moto")){
			valorTotal = this.calcularCostoParqueada(horasParqueadas, COSTO_HORA_MOTO, COSTO_DIA_MOTO);
			int cilindraje = vehiculo.getCilindraje();
			valorTotal = cilindraje>500 ? valorTotal + 2000 : valorTotal;
		}else if(vehiculo.getTipoVehiculo().equalsIgnoreCase("carro")) {
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
