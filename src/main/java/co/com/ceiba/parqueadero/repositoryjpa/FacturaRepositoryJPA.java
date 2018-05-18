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
	
	
//	@Query(name="SELECT id, fecha_fin, fecha_inicio, valor_total, vehiculo_id," + 
//			"valor_total" + 
//			" FROM public.factura WHERE vehiculo_id = (SELECT id from vehiculo where placa = ?1);",
//			nativeQuery=true)
//	FacturaEntity findByPlacaVehiculo(String placaVehiculo); 
}
