package co.com.ceiba.parqueadero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	private static final String INDEX = "inicio/index";

	public InicioController() {
		super();
	}
	
	@GetMapping("/index")
	public String init(){
		return INDEX;
	}
}
