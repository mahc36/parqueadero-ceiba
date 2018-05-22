package co.com.ceiba.parqueadero.repositoryjpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.entity.FacturaEntity;

@Repository
public interface FacturaRepositoryJPA extends JpaRepository<FacturaEntity, Serializable>{

	@Query(name="select * from factura where vehiculo_id = ?1", nativeQuery=true)
	FacturaEntity findByVehiculoId(int vehiculoId);	
	
}
