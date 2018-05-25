package co.com.ceiba.parqueadero.excepcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManejadorExcepciones {
	
	public ManejadorExcepciones() {
		super();
	}
	
	@ExceptionHandler({ ParqueaderoExcepcion.class })
	@ResponseStatus(value=HttpStatus.PRECONDITION_REQUIRED)
	public @ResponseBody Map<String, String> manejarExcepcion(HttpServletRequest request, Exception ex ) {
		Map<String, String> mensajeError = new HashMap<>();
		mensajeError.put("mensaje", ex.getMessage());
		return mensajeError;
	}
}	
