package pe.edu.universidad.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.entidades.Inventario;

@Path("ServicioGestorCatalogo")
@Stateless
@LocalBean
public class InventarioService {
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;

	@GET
	@Path("consultarCatalogo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<DtoCatalogoProducto> consultarCatalogo() {
		List<DtoCatalogoProducto> dtolistacatalogo = new ArrayList<DtoCatalogoProducto>();
		TypedQuery<Inventario> query = em.createQuery("SELECT i FROM Inventario i", Inventario.class);
		
		for (Inventario inventario : query.getResultList()) {
			DtoCatalogoProducto dtoCatalogoProducto = new DtoCatalogoProducto();
			dtoCatalogoProducto.setIdInventario(inventario.getIdInventario());
			dtoCatalogoProducto.setCantidadDisponible(inventario.getCantidadDisponible());
			dtoCatalogoProducto.setFechaIngreso(inventario.getFechaIngreso());
			dtoCatalogoProducto.setProducto(inventario.getProducto());
			dtolistacatalogo.add(dtoCatalogoProducto);
		}
		return dtolistacatalogo;
	}

}
