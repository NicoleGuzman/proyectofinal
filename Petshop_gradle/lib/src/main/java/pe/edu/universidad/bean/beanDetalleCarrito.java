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
//********************************//	
	public List<DetallesCarrito> obtenerDetallesCarritoPorCliente(Integer idUsuario) {
		
		Usuario IdUsuario = new Usuario();		
		
		List<DetallesCarrito> detallesCarrito = getResultList();
		
		return detallesCarrito;
	}
	
}
