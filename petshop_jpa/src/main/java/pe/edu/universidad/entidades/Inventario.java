package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@NamedQuery(name="Inventario.findAll", query="SELECT i FROM Inventario i")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_inventario")
	private Integer idInventario;

	@Column(name="cantidad_disponible")
	private Integer cantidadDisponible;

	@Column(name="cantidad_reservada")
	private Integer cantidadReservada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public Inventario() {
	}

	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Integer getCantidadDisponible() {
		return this.cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Integer getCantidadReservada() {
		return this.cantidadReservada;
	}

	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}