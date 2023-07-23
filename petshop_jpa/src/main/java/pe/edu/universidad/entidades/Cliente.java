package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private Integer idCliente;

	private String contrasena;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	private String dni;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="cliente")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cliente")
	private List<Usuario> usuarios;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setCliente(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setCliente(null);

		return carrito;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCliente(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCliente(null);

		return usuario;
	}

}