package co.com.ceiba.parqueadero.dominio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.parqueadero.entity.TipoVehiculo;
import co.com.ceiba.parqueadero.manager.impl.TipoVehiculoManager;
import co.com.ceiba.parqueadero.repository.TipoVehiculoRepository;
import co.com.ceiba.parqueadero.service.ITipoVehiculoService;
import co.com.ceiba.parqueadero.service.impl.TipoVehiculoService;
import co.com.ceiba.parqueadero.testdatabuilder.TipoVehiculoTestDataBuilder;

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
		TipoVehiculoManager tipoVehiculoManager = new TipoVehiculoManager();
		boolean esperado = false;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  tipoVehiculoManager.permitirEntrada("ABS-923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaDiferenteATest() throws ParseException{
		
		//Arrange
		TipoVehiculoManager tipoVehiculoManager = new TipoVehiculoManager();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  tipoVehiculoManager.permitirEntrada("USF-08D",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
}
