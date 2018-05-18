package co.com.ceiba.parqueadero.repositoryjpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.entity.VehiculoEntity;

@Repository
public interface VehiculoRepositoryJPA extends JpaRepository<VehiculoEntity, Serializable>{
	
	@Query(value = "select * from vehiculo where placa = ?1 and estado = true;", nativeQuery = true)
	VehiculoEntity findByPlacaEnTrue(String placa);
	
	
	@Query(value = "select * from vehiculo where id=?1;", nativeQuery = true)
	VehiculoEntity findById(int id);
	
	VehiculoEntity findByPlaca(String placa);
	
	@Query(value = "select * from vehiculo where estado = true;",nativeQuery=true)
	List<VehiculoEntity> vehiculosParqueados();
}
