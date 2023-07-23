package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_carrito")
	private Integer idCarrito;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to DetallesCarrito
	@OneToMany(mappedBy="carrito")
	private List<DetallesCarrito> detallesCarritos;

	public Carrito() {
	}

	public Integer getIdCarrito() {
		return this.idCarrito;
	}

	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallesCarrito> getDetallesCarritos() {
		return this.detallesCarritos;
	}

	public void setDetallesCarritos(List<DetallesCarrito> detallesCarritos) {
		this.detallesCarritos = detallesCarritos;
	}

	public DetallesCarrito addDetallesCarrito(DetallesCarrito detallesCarrito) {
		getDetallesCarritos().add(detallesCarrito);
		detallesCarrito.setCarrito(this);

		return detallesCarrito;
	}

	public DetallesCarrito removeDetallesCarrito(DetallesCarrito detallesCarrito) {
		getDetallesCarritos().remove(detallesCarrito);
		detallesCarrito.setCarrito(null);

		return detallesCarrito;
	}

}