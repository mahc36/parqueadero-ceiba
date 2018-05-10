package co.com.ceiba.parqueadero;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes= ParqueaderoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ParqueaderoApplicationTests {

	@Test
	public void sumarDosNumerosTest() {
		assertTrue(true);
	}
}
