package co.com.ceiba.parqueadero.dominio.unitarias;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.IVehiculoService;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class VehiculoTest {	
	
	@Autowired
	IVehiculoService vehiculoService;
	
	@Before 
	public void initialize() {
		
	}
	    
	//
	@Test
	public void placaIniciaConADomingoTest() throws ParseException{
		
		//Arrange
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoService.permitirEntradaPlacaIniciadaA("ABS923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaConALunesTest() throws ParseException{
		
		//Arrange
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("14-05-2018");
		
		//Act
		boolean retorno =  vehiculoService.permitirEntradaPlacaIniciadaA("ABS923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaConAJuevesTest() throws ParseException{
		
		//Arrange
		boolean esperado = false;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("17-05-2018");
		
		//Act
		boolean retorno =  vehiculoService.permitirEntradaPlacaIniciadaA("ABS923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaDiferenteATest() throws ParseException{
		
		//Arrange
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoService.permitirEntradaPlacaIniciadaA("USF08D",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void ingresarMotoTest() {
		//Arrange
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().build();
		boolean resultadoEsperado = true; 
		
		// Act
		boolean resultado = vehiculoService.permitirParquearTipoVehiculo(vehiculoTest.getTipoVehiculo());
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void ingresarCarroTest() {
		//Arrange
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().conTipoVehiculo("carro").build();
		boolean resultadoEsperado = true; 
		
		// Act
		boolean resultado = vehiculoService.permitirParquearTipoVehiculo(vehiculoTest.getTipoVehiculo());
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void ingresarVehiculoNoPermitidoTest() {
		//Arrange
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().conTipoVehiculo("Tractomula").build();
		boolean resultadoEsperado = false;
		
		//Act
		boolean resultado = vehiculoService.permitirParquearTipoVehiculo(vehiculoTest.getTipoVehiculo());
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
}

