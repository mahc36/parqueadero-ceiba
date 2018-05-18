package co.com.ceiba.parqueadero.converter;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.entity.TipoVehiculoEntity;
import co.com.ceiba.parqueadero.model.TipoVehiculo;

public class TipoVehiculoConverter {

	public TipoVehiculoConverter() {
		super();
	}
	
	public TipoVehiculo convertirEntity2Model(TipoVehiculoEntity tipoVehiculoEntity) {
		if(tipoVehiculoEntity==null) return null;
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		tipoVehiculo.setId(tipoVehiculoEntity.getId());
		tipoVehiculo.setNombreTipo(tipoVehiculoEntity.getNombreTipo());
		
		return tipoVehiculo;
	}
	
	public TipoVehiculoEntity convertirModel2Entity(TipoVehiculo tipoVehiculo) {
		if(tipoVehiculo == null) return null;
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setId(tipoVehiculo.getId());
		tipoVehiculoEntity.setNombreTipo(tipoVehiculo.getNombreTipo());
		
		return tipoVehiculoEntity;
	}
	
	public List<TipoVehiculo> convertirListaEntity2Model(List<TipoVehiculoEntity> listaEntity ){
		List<TipoVehiculo> listaModel = new ArrayList<>();
		for(TipoVehiculoEntity tipoVehiculoEntity: listaEntity) {
			listaModel.add(this.convertirEntity2Model(tipoVehiculoEntity));
		}
		return listaModel;
	}
	
	public List<TipoVehiculoEntity> convertirListaModel2Entity(List<TipoVehiculo> listaModel){
		List<TipoVehiculoEntity> listaEntity = new ArrayList<>();
		for(TipoVehiculo tipoVehiculo:listaModel) {
			listaEntity.add(this.convertirModel2Entity(tipoVehiculo));
		}
		return listaEntity;
	}
}
