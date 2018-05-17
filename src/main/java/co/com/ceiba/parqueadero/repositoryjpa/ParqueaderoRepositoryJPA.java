package co.com.ceiba.parqueadero.repositoryjpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.parqueadero.entity.ParqueaderoEntity;

public interface ParqueaderoRepositoryJPA extends JpaRepository<ParqueaderoEntity, Serializable>{

}
