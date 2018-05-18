package co.com.ceiba.parqueadero.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.converter.VehiculoConverter;
import co.com.ceiba.parqueadero.entity.VehiculoEntity;
import co.com.ceiba.parqueadero.model.Vehiculo;
import co.com.ceiba.parqueadero.repository.IVehiculoRepository;
import co.com.ceiba.parqueadero.repositoryjpa.VehiculoRepositoryJPA;

@Service
public class VehiculoRepository implements IVehiculoRepository {

	@Autowired
	VehiculoRepositoryJPA vehiculoRepositoryJPA;
	@PersistenceContext
	EntityManager entityManager;
	VehiculoConverter vehiculoConverter = new VehiculoConverter();
	
	public VehiculoRepository() {
		super();
	}
	
	@Override
	public Vehiculo agregarAlParqueadero(Vehiculo vehiculo) {
		VehiculoEntity vehiculoInsertar =  vehiculoRepositoryJPA.save(vehiculoConverter.convertirModel2Entity(vehiculo));
		return vehiculoConverter.convertirEntity2Model(vehiculoInsertar);
	}

	@Override
	public Vehiculo vehiculoEstaParqueado(String placa) {
		VehiculoEntity vehiculoParqueadoEntity = vehiculoRepositoryJPA.findByPlacaEnTrue(placa);
		return vehiculoConverter.convertirEntity2Model(vehiculoParqueadoEntity);
	}

	@Override
	public Vehiculo findById(int id) {
		return vehiculoConverter.convertirEntity2Model(vehiculoRepositoryJPA.findById(id));
	}

	@Override
	public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
		VehiculoEntity vehiculoActualizar = vehiculoConverter.convertirModel2Entity(vehiculo);
		return vehiculoConverter.convertirEntity2Model(vehiculoRepositoryJPA.save(vehiculoActualizar));
	}

	@Override
	public Vehiculo findByPlaca(String placa) {
		return vehiculoConverter.convertirEntity2Model(vehiculoRepositoryJPA.findByPlaca(placa));
	}

	@Override
	public List<Vehiculo> vehiculosParqueados() {
		return vehiculoConverter.convertirListaEntity2Model(vehiculoRepositoryJPA.vehiculosParqueados());
	}

	@Override
	public int cantidadMotoParqueadas() {
		return entityManager.createNamedQuery("motosParqueadas",VehiculoEntity.class).getResultList().size();
	}

	@Override
	public int cantidadCarrosParqueados() {
		return entityManager.createNamedQuery("carrosParqueados",VehiculoEntity.class).getResultList().size();
	}
}
