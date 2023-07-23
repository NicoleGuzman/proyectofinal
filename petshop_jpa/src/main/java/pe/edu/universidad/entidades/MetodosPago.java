package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodos_pago database table.
 * 
 */
@Entity
@Table(name="metodos_pago")
@NamedQuery(name="MetodosPago.findAll", query="SELECT m FROM MetodosPago m")
public class MetodosPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_metodo_pago")
	private Integer idMetodoPago;

	private String nombre;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="metodosPago")
	private List<Pedido> pedidos;

	public MetodosPago() {
	}

	public Integer getIdMetodoPago() {
		return this.idMetodoPago;
	}

	public void setIdMetodoPago(Integer idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setMetodosPago(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setMetodosPago(null);

		return pedido;
	}

}