package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import pe.edu.universidad.dto.DtoDetalleCarrito;
import pe.edu.universidad.service.DetalleCarritoService;

@Named
@SessionScoped
public class beanDetalleCarrito implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private DetalleCarritoService detalleCarritoService;
	
	private List<DtoDetalleCarrito> listaCarrito; 
	
	
	public String obtenerDetallesCarritoPorCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		setListaCarrito(detalleCarritoService.obtenerDetallesCarritoPorCliente(idCliente));
		return "detalleCarrito.xhtml";
	}

	public List<DtoDetalleCarrito> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<DtoDetalleCarrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	

	
	
}
