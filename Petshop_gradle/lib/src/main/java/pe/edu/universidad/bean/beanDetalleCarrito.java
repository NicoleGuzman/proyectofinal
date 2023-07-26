package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;



import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.entidades.DetallesCarrito;
import pe.edu.universidad.entidades.Usuario;
import pe.edu.universidad.service.DetalleCarritoService;
import pe.edu.universidad.service.InventarioService;

@Named
@SessionScoped
public class beanDetalleCarrito implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private DetalleCarritoService detalleCarritoService;
	
	private List<DetallesCarrito> listaCarrito; 
	
	@PostConstruct
	public void obtenerDetallesCarritoPorCliente(Integer idUsuario) {
		
		Usuario IdUsuario = new Usuario();			
	}

	public List<DetallesCarrito> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<DetallesCarrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	
	
}
