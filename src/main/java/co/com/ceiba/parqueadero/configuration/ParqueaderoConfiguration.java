package co.com.ceiba.parqueadero.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.service.impl.TipoVehiculoService;

@Configuration
public class ParqueaderoConfiguration {

	public ParqueaderoConfiguration() {
		super();
	}
	
	@Bean
	@Qualifier("tipoVehiculos")
	public TipoVehiculoService creaTipoVehiculosService() {
		return new TipoVehiculoService();
	}

}
