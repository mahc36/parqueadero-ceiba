package co.com.ceiba.parqueadero.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.IVigilanteService;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class VigilanteTest {

	private static final String NO_PARQUEAR_DOMINGOS_NI_LUNES = "Las placas iniciadas en A no se pueden parquear los domingos y los lunes";
	private static final String VEHICULO_NO_PERMITIDO ="Solo se permiten motos y carros";
	private static final String VEHICULO_ESTA_PARQUEADO = "El vehículo ya se encuentra parqueado";
	private static final String VEHICULO_NO_ESTA_PARQUEADO = "El vehículo no se encuentra parqueado";
	private static final String NO_HAY_CELDAS_DISPONIBLES = "Lo sentimos, no hay celdas disponibles";
	
	@Autowired
	private IVigilanteService vigilanteService;
	
	public VigilanteTest() {
		super();
	}
	
	@Test
	public void parquearVehiculoTest() {
		//Arrange
		Vehiculo vehiculoAgregar = new VehiculoTestDataBuilder().build();
		int cantidadVehiculos = vigilanteService.vehiculosParqueados().size();
		int cantidadEsperada = cantidadVehiculos+1;
		//Act
		vigilanteService.parquear(vehiculoAgregar);
		int cantidadVehiculosActualizada = vigilanteService.vehiculosParqueados().size();
		//Assert
		assertEquals(cantidadEsperada, cantidadVehiculosActualizada);
		
	}
	
	@Test
	public void parquearConPlacaIniciadaEnAtest() {
		//Arrange
		Vehiculo vehiculoAgregar = new VehiculoTestDataBuilder().conPlaca("AAA111").build();
		try {
			vigilanteService.parquear(vehiculoAgregar);
			fail("Se esperaba que fallara");
		} catch (ParqueaderoExcepcion e) {
			assertEquals(NO_PARQUEAR_DOMINGOS_NI_LUNES, e.getMessage());
		}
	}
	
	@Test
	public void parquearVehiculoParqueadoTest() {
		//Arrange		
		Vehiculo vehiculoAgregar = new VehiculoTestDataBuilder().conId(1).conPlaca("RJA147").build();
		Vehiculo vehiculoAgregarRepetido = new VehiculoTestDataBuilder().conId(2).conPlaca("RJA147").build();
		vigilanteService.parquear(vehiculoAgregar);
		//Act
		try {
			vigilanteService.parquear(vehiculoAgregarRepetido);
			fail("Se esperaba que fallara");
		}catch (ParqueaderoExcepcion e) {
			//Assert
			assertEquals(VEHICULO_ESTA_PARQUEADO, e.getMessage());
		}
	}
	
	@Test
	public void celdasNoDisponibles(){
		
	}
	
	@Test
	public void sacarVehiculoNoParqueaderoTest() {
		//Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo("moto").build();
		vigilanteService.parquear(vehiculo);
		vigilanteService.sacarVehiculo(vehiculo.getPlaca());
		
		//Act
		try {
			vigilanteService.sacarVehiculo(vehiculo.getPlaca());
			fail();
		}catch (ParqueaderoExcepcion e) {
			//Assert
			assertEquals(VEHICULO_NO_ESTA_PARQUEADO, e.getMessage());
		}
	}
}
