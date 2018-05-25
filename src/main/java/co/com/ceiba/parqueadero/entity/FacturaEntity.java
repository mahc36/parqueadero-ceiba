package co.com.ceiba.parqueadero.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedNativeQueries({
	@NamedNativeQuery(
			name="consultarFacturaByPlaca",
			query="SELECT id, fecha_fin, fecha_inicio, valor_total, vehiculo_id,valor_total" + 
			" FROM public.factura WHERE vehiculo_id = (SELECT id from vehiculo where placa = ?1);",
			resultClass=FacturaEntity.class),
	@NamedNativeQuery(name="facturasvehiculosactivos",
			query="select * from vehiculo inner join factura ON (vehiculo.id = factura.vehiculo_id) where vehiculo.estado = true;",
			resultClass=FacturaEntity.class)
})


@Table(name="factura")
public class FacturaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="valor_total")
	private int valorTotal;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	@OneToOne
	private VehiculoEntity vehiculo;
	
	public FacturaEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
}
