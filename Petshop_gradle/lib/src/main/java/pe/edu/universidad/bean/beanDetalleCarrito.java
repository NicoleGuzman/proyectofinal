package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.entidades.DetallesCarrito;
import pe.edu.universidad.entidades.Usuario;
import pe.edu.universidad.service.DetalleCarritoService;
import pe.edu.universidad.service.InventarioService;

@Named
@SessionScoped
public class beanDetalleCarrito implements Serializable{
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;

	private static final long serialVersionUID = 1L;
	@Inject
	private DetalleCarritoService detalleCarritoService;
//********************************//	
	public List<DetallesCarrito> obtenerDetallesCarritoPorCliente(Integer idUsuario) {
		TypedQuery<DetallesCarrito> query = em.createQuery(
				"SELECT dc FROM DetallesCarrito dc JOIN dc.carrito c WHERE c.cliente.idCliente = :idCliente",
				DetallesCarrito.class);
		
		Usuario IdUsuario = new Usuario();		
		query.setParameter("idCliente", idUsuario);
		List<DetallesCarrito> detallesCarrito = query.getResultList();
		
		return detallesCarrito;
	}
	
}
