package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto")
	private Integer idProducto;

	private String categoria;

	private String descripcion;

	private String especificaciones;

	private String imagen;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-one association to DetallesCarrito
	@OneToMany(mappedBy="producto")
	private List<DetallesCarrito> detallesCarritos;

	//bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy="producto")
	private List<Inventario> inventarios;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="proveedor_id")
	private Proveedore proveedore;

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEspecificaciones() {
		return this.especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetallesCarrito> getDetallesCarritos() {
		return this.detallesCarritos;
	}

	public void setDetallesCarritos(List<DetallesCarrito> detallesCarritos) {
		this.detallesCarritos = detallesCarritos;
	}

	public DetallesCarrito addDetallesCarrito(DetallesCarrito detallesCarrito) {
		getDetallesCarritos().add(detallesCarrito);
		detallesCarrito.setProducto(this);

		return detallesCarrito;
	}

	public DetallesCarrito removeDetallesCarrito(DetallesCarrito detallesCarrito) {
		getDetallesCarritos().remove(detallesCarrito);
		detallesCarrito.setProducto(null);

		return detallesCarrito;
	}

	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setProducto(this);

		return inventario;
	}

	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setProducto(null);

		return inventario;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

}