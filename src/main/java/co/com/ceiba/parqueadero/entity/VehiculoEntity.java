package co.com.ceiba.parqueadero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="motosParqueadas", query="select * from vehiculo where tipo_vehiculo='moto' and estado = true",resultClass=VehiculoEntity.class),
	@NamedNativeQuery(name="carrosParqueados",query="select * from vehiculo where tipo_vehiculo='carro' and estado = true",resultClass=VehiculoEntity.class)
})

@Table(name="vehiculo")
public class VehiculoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="cilindraje")
	private int cilindraje;
	@Column(name="placa")
	private String placa;
	@Column(name="tipo_vehiculo")
	private String tipoVehiculo;
	@Column(name="estado")
	private boolean estado;
	
	public VehiculoEntity() {
		super();
	}
	
	public VehiculoEntity(int id, int cilindraje, String placa, String tipoVehiculo, boolean estado) {
		super();
		this.id = id;
		this.cilindraje = cilindraje;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
