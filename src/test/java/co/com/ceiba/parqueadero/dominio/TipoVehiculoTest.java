package co.com.ceiba.parqueadero.dominio;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.parqueadero.manager.impl.VehiculoManager;

public class TipoVehiculoTest {

//	@Test
//	public void motoTest() {
//		
//		//arrange
//		
//		TipoVehiculoTestDataBuilder tipoVehiculoDataBuilder = new TipoVehiculoTestDataBuilder().conNombreTipo("carro").conId(2);
//		TipoVehiculo tipoVehiculo = tipoVehiculoDataBuilder.build();
//		TipoVehiculoService tipoVehiculoService = new TipoVehiculoService();
////		List<TipoVehiculo> tiposVehiculos = new ArrayList<>();
////		tiposVehiculos.add(tipoVehiculo);
////		TipoVehiculoRepository tipoRepo = mock(TipoVehiculoRepository.class);
//		//act
////		when(tipoRepo.findAll()).thenReturn(tiposVehiculos);
//		List<TipoVehiculo> tiposVehiculos =  tipoVehiculoService.tiposVehiculos();
//
//		//assert
//		assertEquals(tipoVehiculo,tiposVehiculos.get(1));
//	}
	
	
	@Test
	public void placaIniciaConATest() throws ParseException{
		
		//Arrange
		VehiculoManager vehiculoManager = new VehiculoManager();
		boolean esperado = false;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntrada("ABS-923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaDiferenteATest() throws ParseException{
		
		//Arrange
		VehiculoManager vehiculoManager = new VehiculoManager();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntrada("USF-08D",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
}
