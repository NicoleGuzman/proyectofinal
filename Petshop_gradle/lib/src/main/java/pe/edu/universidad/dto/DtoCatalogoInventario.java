package pe.edu.universidad.dto;

import java.util.Date;

import pe.edu.universidad.entidades.Producto;

public class DtoCatalogoInventario {
	
	private int idInventario;
	private int cantidadDisponible;
	private Date fechaIngreso;
	private DtoCatalogoProducto dtoCatalogoProducto;
	
	public int getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public DtoCatalogoProducto getDtoCatalogoProducto() {
		return dtoCatalogoProducto;
	}
	public void setDtoCatalogoProducto(DtoCatalogoProducto dtoCatalogoProducto) {
		this.dtoCatalogoProducto = dtoCatalogoProducto;
	}
	
}
