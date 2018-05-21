package co.com.ceiba.parqueadero.dominio;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.impl.FacturaService;
import co.com.ceiba.parqueadero.service.impl.VehiculoService;
import co.com.ceiba.parqueadero.testdatabuilder.FacturaTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

public class TipoVehiculoTest {	
	
	@Test
	public void placaIniciaConADomingoTest() throws ParseException{
		
		//Arrange
		VehiculoService vehiculoManager = new VehiculoService();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntradaPlacaIniciadaA("ABS-923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaConALunesTest() throws ParseException{
		
		//Arrange
		VehiculoService vehiculoManager = new VehiculoService();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("14-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntradaPlacaIniciadaA("ABS-923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaConATest() throws ParseException{
		
		//Arrange
		VehiculoService vehiculoManager = new VehiculoService();
		boolean esperado = false;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("17-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntradaPlacaIniciadaA("ABS-923",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	@Test
	public void placaIniciaDiferenteATest() throws ParseException{
		
		//Arrange
		VehiculoService vehiculoManager = new VehiculoService();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntradaPlacaIniciadaA("USF08D",fechaSolicitud);
		
		//Assert
		assertEquals(retorno, esperado);
	}
	
	
	@Test
	public void ingresarVehiculoPermitidoTest() {
		//Arrange
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().build();
		VehiculoService vehiculoManager = new VehiculoService();
		boolean resultadoEsperado = true; 
		
		// Act
		boolean resultado = vehiculoManager.permitirParquearTipoVehiculo(vehiculoTest.getTipoVehiculo());
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void ingresarVehiculoNoPermitidoTest() {
		//Arrange
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().conTipoVehiculo("Tractomula").build();
		VehiculoService vehiculoManager = new VehiculoService();
		boolean resultadoEsperado = false;
		
		//Act
		boolean resultado = vehiculoManager.permitirParquearTipoVehiculo(vehiculoTest.getTipoVehiculo());
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void horasParqueadoTest() {
		//Arrange
		FacturaService facturaService = new FacturaService();
		Date fechaIngreso = facturaService.crearFecha(2018, 5, 17, 14, 4, 25);
		Date fechaSalida = facturaService.crearFecha(2019, 5, 17, 14, 4, 25);
		int tiempoEsperado = 8760;
		
		//Act
		int resultado = facturaService.tiempoParqueado(fechaIngreso, fechaSalida);
		
		//assert
		assertEquals(tiempoEsperado, resultado);
	}
	
	@Test
	public void calcularCostoParqueadaMotoTest(){
		
		//Arrange
		FacturaService facturaService = new FacturaService();
		int valorEsperado = 7500;
		int horasParqueadas = 31; 
		int valorHora = 500;
		int valorDia = 4000;
		
		//Act
		int valorParqueada = facturaService.calcularCostoParqueada(horasParqueadas, valorHora, valorDia);
		
		//Assert
		assertEquals(valorEsperado, valorParqueada);
	}
	
	@Test
	public void calcularCostoParqueadoCarroTest(){
		
		//Arrange
		FacturaService facturaService = new FacturaService();
		Date fechaIngreso = facturaService.crearFecha(2018, 5, 17, 14, 4, 25);
		Date fechaSalida = facturaService.crearFecha(2018, 5, 18, 17, 4, 24);
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().conTipoVehiculo("carro").conPlaca("ABS063").conCilindraje(3000).build();
		Factura facturaTest = new FacturaTestDataBuilder().conVehiculo(vehiculoTest).conFechaInicio(fechaIngreso).conFechaFin(fechaSalida).build();
		int valorEsperado = 11000;
		
		//Act
		Factura facturaGenerada = facturaService.calcularValorTotalParqueada(facturaTest, vehiculoTest);
		
		//Assert
		assertEquals(valorEsperado, facturaGenerada.getValorTotal());
	}

}

