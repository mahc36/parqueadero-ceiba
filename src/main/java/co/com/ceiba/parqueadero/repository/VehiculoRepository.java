package co.com.ceiba.parqueadero.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.parqueadero.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Serializable>{

}
