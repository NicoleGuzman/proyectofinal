package pe.edu.universidad.dto;


public class DtoDetalleCarrito {
	private int idDettalle;
	private int cantidad;
	private DtoDetalleProducto dtoDetalleProducto;
	public int getIdDettalle() {
		return idDettalle;
	}
	public void setIdDettalle(int idDettalle) {
		this.idDettalle = idDettalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public DtoDetalleProducto getDtoDetalleProducto() {
		return dtoDetalleProducto;
	}
	public void setDtoDetalleProducto(DtoDetalleProducto dtoDetalleProducto) {
		this.dtoDetalleProducto = dtoDetalleProducto;
	}
	
}
