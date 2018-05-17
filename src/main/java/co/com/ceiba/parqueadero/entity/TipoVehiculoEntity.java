package co.com.ceiba.parqueadero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_vechiculo")
public class TipoVehiculoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="nombre_tipo")
	private String nombreTipo;
	
	public TipoVehiculoEntity() {
		super();
	}
	
	public TipoVehiculoEntity(int id,String nombreTipo){
		this.id=id;
		this.nombreTipo=nombreTipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
}
