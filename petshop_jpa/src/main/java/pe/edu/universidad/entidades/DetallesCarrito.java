package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalles_carrito database table.
 * 
 */
@Entity
@Table(name="detalles_carrito")
@NamedQuery(name="DetallesCarrito.findAll", query="SELECT d FROM DetallesCarrito d")
public class DetallesCarrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalle")
	private Integer idDetalle;

	private Integer cantidad;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Carrito
	@ManyToOne
	@JoinColumn(name="id_carrito")
	private Carrito carrito;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public DetallesCarrito() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}