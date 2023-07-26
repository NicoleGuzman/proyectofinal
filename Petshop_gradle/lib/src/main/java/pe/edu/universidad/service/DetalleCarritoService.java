package pe.edu.universidad.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.universidad.entidades.DetallesCarrito;
import pe.edu.universidad.entidades.Usuario;

@Path("DetalleCarritoService")
@Stateless
@LocalBean
public class DetalleCarritoService {
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;
	
	@GET
	@Path("buscarPorIdUsuario/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario buscarPorIdUsuario(@PathParam("idUsuario") int idUsuario) {
       return em.find(Usuario.class, idUsuario);
    }
	
	@GET
	@Path("obtenerDetallesCarritoPorCliente/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<DetallesCarrito> obtenerDetallesCarritoPorCliente(Integer idUsuario) {
		TypedQuery<DetallesCarrito> query = em.createQuery(
				"SELECT dc FROM DetallesCarrito dc JOIN dc.carrito c WHERE c.cliente.idCliente = :idCliente",
				DetallesCarrito.class);
		query.setParameter("idCliente", idUsuario);
		List<DetallesCarrito> detallesCarrito = query.getResultList();
		
		return detallesCarrito;
	}
	
	

}
