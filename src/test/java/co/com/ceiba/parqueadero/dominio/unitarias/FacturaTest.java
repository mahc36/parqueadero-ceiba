package co.com.ceiba.parqueadero.dominio.unitarias;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.model.Factura;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.IFacturaService;
import co.com.ceiba.parqueadero.testdatabuilder.FacturaTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class FacturaTest {
	
	@Autowired
	IFacturaService facturaService;
	
	@Test
	public void horasParqueadoTest() {
		//Arrange
		Date fechaIngreso = facturaService.crearFecha(2018, 5, 17, 14, 4, 25);
		Date fechaSalida = facturaService.crearFecha(2019, 5, 17, 14, 4, 25);
		int tiempoEsperado = 8760;
		
		//Act
		int resultado = facturaService.tiempoParqueado(fechaIngreso, fechaSalida);
		
		//assert
		assertEquals(tiempoEsperado, resultado);
	}
	
	@Test
	public void calcularCostoParqueadoMotoTest(){
		
		//Arrange
		Date fechaIngreso = facturaService.crearFecha(2018, 5, 17, 14, 4, 25);
		Date fechaSalida = facturaService.crearFecha(2018, 5, 19, 17, 4, 24);
		Vehiculo vehiculoTest = new VehiculoTestDataBuilder().conTipoVehiculo("moto").conPlaca("USF02D").conCilindraje(1200).build();
		Factura facturaTest = new FacturaTestDataBuilder().conVehiculo(vehiculoTest).conFechaInicio(fechaIngreso).conFechaFin(fechaSalida).build();
		int valorEsperado = 11500;
		
		//Act
		Factura facturaGenerada = facturaService.calcularValorTotalParqueada(facturaTest, vehiculoTest);
		
		//Assert
		assertEquals(valorEsperado, facturaGenerada.getValorTotal());
	}
	
	@Test
	public void calcularCostoParqueadoCarroTest(){
		
		//Arrange
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
