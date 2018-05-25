package co.com.ceiba.parqueadero.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.service.IVigilanteService;
import co.com.ceiba.parqueadero.service.impl.VigilanteService;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class VigilanteTest {

	private static final String PARQUEAR_SOLO_DOMINGOS_Y_LUNES = "Las placas iniciadas en A solo se pueden parquear los Domingos y los Lunes";
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
	public void parquearVehiculoTest() throws ParqueaderoExcepcion {
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
			assertEquals(PARQUEAR_SOLO_DOMINGOS_Y_LUNES, e.getMessage());
		}
	}
	
	@Test
	public void parquearVehiculoParqueadoTest() throws ParqueaderoExcepcion {
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
	public void sacarVehiculoNoParqueaderoTest() throws ParqueaderoExcepcion {
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
	
	
	@Test()
	public void celdasNoDisponiblesTest() throws ParqueaderoExcepcion{
		//Arrange
		Vehiculo vehiculoParquear = new VehiculoTestDataBuilder().conPlaca("ABC123").build();
		VigilanteService vigilanteService = mock(VigilanteService.class); 
		when(vigilanteService.parquear(vehiculoParquear)).thenThrow(new ParqueaderoExcepcion(NO_HAY_CELDAS_DISPONIBLES));
		
		//Act
		try {
			vigilanteService.parquear(vehiculoParquear);
			fail("Se esperaba que fallase");
		}catch (ParqueaderoExcepcion e) {
			//Assert
			assertEquals(NO_HAY_CELDAS_DISPONIBLES, e.getMessage());
		}
	}
	
	@Test()
	public void vehiculoNoPermitidoTest() {
		//Arrange
		Vehiculo vehiculoParquear = new VehiculoTestDataBuilder().conTipoVehiculo("Camión").build();
		//Act
		try {
			vigilanteService.parquear(vehiculoParquear);
		} catch (ParqueaderoExcepcion e) {
			//Assert
			assertEquals(VEHICULO_NO_PERMITIDO, e.getMessage());
		}
	}
}
