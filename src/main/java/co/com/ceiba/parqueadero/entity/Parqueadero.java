package co.com.ceiba.parqueadero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "parqueadero")
public class Parqueadero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Range(min=0,max=20)
	@Column(name = "cantidad_carro")
	private int cantidadCarros;
	@Range(min=0,max=10)
	@Column(name="cantidad_motos")
	private int cantidadMotos;
	
	public Parqueadero() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadCarros() {
		return cantidadCarros;
	}

	public void setCantidadCarros(int cantidadCarros) {
		this.cantidadCarros = cantidadCarros;
	}

	public int getCantidadMotos() {
		return cantidadMotos;
	}

	public void setCantidadMotos(int cantidadMotos) {
		this.cantidadMotos = cantidadMotos;
	}
}
