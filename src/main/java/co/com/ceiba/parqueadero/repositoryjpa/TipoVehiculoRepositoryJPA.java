package co.com.ceiba.parqueadero.repositoryjpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.entity.TipoVehiculoEntity;

@Repository
public interface TipoVehiculoRepositoryJPA extends JpaRepository<TipoVehiculoEntity,Serializable>{

}
