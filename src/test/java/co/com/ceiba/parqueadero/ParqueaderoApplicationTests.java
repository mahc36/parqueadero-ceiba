package co.com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes= ParqueaderoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ParqueaderoApplicationTests {

	@Test
	public void sumarDosNumerosTest() {
		//arrange
		int numero1=3;
		int numero2=3;
		
		//act
		int suma = numero1 + numero2;
		
		//assert
		
		assertEquals(5, suma);
	}
}
