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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.universidad.dto.DtoDetalleCarrito;
import pe.edu.universidad.dto.DtoDetalleProducto;
import pe.edu.universidad.dto.DtoIdUsuario;
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
	public DtoIdUsuario buscarPorIdUsuario(@PathParam("idUsuario") int idUsuario) {
		
		Usuario usuario= em.find(Usuario.class, idUsuario);
		
		DtoIdUsuario dtoIdUsuario = new DtoIdUsuario();
		dtoIdUsuario.setIdUsuario(usuario.getIdUsuario());
		dtoIdUsuario.setNombreUsuario(usuario.getNombreUsuario());
		
       return dtoIdUsuario;
    }
	
	@GET
	@Path("obtenerDetallesCarritoPorCliente/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<DtoDetalleCarrito> obtenerDetallesCarritoPorCliente(@PathParam("idUsuario")int idUsuario) {
		List<DtoDetalleCarrito> dtolistacarrito = new ArrayList<DtoDetalleCarrito>();
		TypedQuery<DetallesCarrito> query = em.createQuery(
				"SELECT dc FROM DetallesCarrito dc JOIN dc.carrito c WHERE c.cliente.idCliente = :idCliente",
				DetallesCarrito.class);
		query.setParameter("idCliente", idUsuario);
		
		for (DetallesCarrito detallesCarrito : query.getResultList()) {
			DtoDetalleCarrito dtoDetalleCarrito = new DtoDetalleCarrito();
			dtoDetalleCarrito.setIdDettalle(detallesCarrito.getIdDetalle());
			dtoDetalleCarrito.setCantidad(detallesCarrito.getCantidad());
			DtoDetalleProducto dtoDetalleProducto = new DtoDetalleProducto();
			dtoDetalleProducto.setIdProducto(detallesCarrito.getProducto().getIdProducto());
			dtoDetalleProducto.setNombre(detallesCarrito.getProducto().getNombre());
			dtoDetalleProducto.setDescripcion(detallesCarrito.getProducto().getDescripcion());
			dtoDetalleProducto.setPrecio(detallesCarrito.getProducto().getPrecio());
			dtoDetalleCarrito.setDtoDetalleProducto(dtoDetalleProducto);
			dtolistacarrito.add(dtoDetalleCarrito);		
		}
		
		return dtolistacarrito;
	}
	
	
	

}
