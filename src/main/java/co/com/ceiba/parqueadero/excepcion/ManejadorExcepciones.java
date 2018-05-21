package co.com.ceiba.parqueadero.excepcion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManejadorExcepciones {

	
	public ManejadorExcepciones() {
		super();
	}
	
	@ExceptionHandler({ ParqueaderoExcepcion.class })
	@ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
	public String manejarExcepcion(HttpServletRequest request, Exception ex ) {
		 return ex.getMessage();
	}
	
}
