package co.com.ceiba.parqueadero.converter;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.entity.FacturaEntity;
import co.com.ceiba.parqueadero.model.Factura;

public class FacturaConverter {
	
	VehiculoConverter vehiculoConverter = new VehiculoConverter();

	public FacturaConverter() {
		super();
	}
	
	public Factura convertirEntity2Model(FacturaEntity facturaEntity) {
		Factura factura = new Factura();
		
		factura.setId(facturaEntity.getId());
		factura.setValorTotal(facturaEntity.getValorTotal());
		factura.setFechaInicio(facturaEntity.getFechaInicio());
		factura.setFechaFin(facturaEntity.getFechaFin());
		factura.setVehiculoModel(vehiculoConverter.convertirEntity2Model(facturaEntity.getVehiculo()));
		
		return factura;
	}
	
	public FacturaEntity convertirModel2Entity(Factura factura) {
		FacturaEntity facturaEntity = new FacturaEntity();
		
		facturaEntity.setId(factura.getId());
		facturaEntity.setValorTotal(factura.getValorTotal());
		facturaEntity.setFechaInicio(factura.getFechaInicio());
		facturaEntity.setFechaFin(factura.getFechaFin());
		facturaEntity.setVehiculo(vehiculoConverter.convertirModel2Entity(factura.getVehiculoModel()));
		
		return facturaEntity;
			
	}
	
	
	public List<Factura> convertirListaEntityToModel(List<FacturaEntity> listaEntity){
		List<Factura> listaModel = new ArrayList<>();
		for(FacturaEntity facturaEntity: listaEntity) {
			Factura factura = this.convertirEntity2Model(facturaEntity);
			listaModel.add(factura);
		}
		return listaModel;
	}
	

}
