package co.com.ceiba.parqueadero.dominio;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.impl.FacturaService;
import co.com.ceiba.parqueadero.service.impl.VehiculoService;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

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
		VehiculoService vehiculoManager = new VehiculoService();
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
		VehiculoService vehiculoManager = new VehiculoService();
		boolean esperado = true;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolicitud = formatoFecha.parse("13-05-2018");
		
		//Act
		boolean retorno =  vehiculoManager.permitirEntrada("USF08D",fechaSolicitud);
		
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

}

