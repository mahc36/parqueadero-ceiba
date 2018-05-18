package co.com.ceiba.parqueadero.converter;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.entity.VehiculoEntity;
import co.com.ceiba.parqueadero.model.Vehiculo;

public class VehiculoConverter {

	public VehiculoConverter() {
		super();
	}
	
	public Vehiculo convertirEntity2Model(VehiculoEntity vehiculoEntity){
		if(vehiculoEntity==null) return null;
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setId(vehiculoEntity.getId());
		vehiculo.setPlaca(vehiculoEntity.getPlaca());
		vehiculo.setCilindraje(vehiculoEntity.getCilindraje());
		vehiculo.setTipoVehiculo(vehiculoEntity.getTipoVehiculo());
		vehiculo.setEstado(vehiculoEntity.isEstado());
		
		return vehiculo;
	}
	
	public VehiculoEntity convertirModel2Entity(Vehiculo vehiculo) {
		if(vehiculo==null) return null;
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		
		vehiculoEntity.setId(vehiculo.getId());
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoEntity.setEstado(vehiculo.isEstado());
		
		return vehiculoEntity;
	}
	
	public List<Vehiculo> convertirListaEntity2Model(List<VehiculoEntity> listaEntity){
		List<Vehiculo> listaModel = new ArrayList<>();
		for(VehiculoEntity vehiculoEntity: listaEntity) {
			listaModel.add(this.convertirEntity2Model(vehiculoEntity));
		}
		return listaModel;
	}
	
	public List<VehiculoEntity> convertirListaModel2Entity(List<Vehiculo> listaModel){
		List<VehiculoEntity> listaEntity = new ArrayList<>();
		for(Vehiculo vehiculo: listaModel) {
			listaEntity.add(this.convertirModel2Entity(vehiculo));
		}
		return listaEntity;
	}
}
