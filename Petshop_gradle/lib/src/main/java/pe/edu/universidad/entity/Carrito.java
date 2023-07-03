package pe.edu.universidad.entity;

public class Carrito {
	private int id_carrito;
	private Cliente cliente;
	private Producto producto;
	private int cantidad;
	public int getId_carrito() {
		return id_carrito;
	}
	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
