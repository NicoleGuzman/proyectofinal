package pe.edu.universidad.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Path("DetalleCarritoService")
@Stateless
@LocalBean
public class DetalleCarritoService {
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;

}
