package pe.edu.universidad.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;

import pe.edu.universidad.entidades.Usuario;

@Path("DetalleCarritoService")
@Stateless
@LocalBean
public class DetalleCarritoService {
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;
	
	public Usuario buscarPorIdUsuario(int idUsuario) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id_Usuario = :id_Usuario", Usuario.class);
        query.setParameter("id_Usuario", idUsuario);
        List<Usuario> resultados = query.getResultList();
        if (resultados.isEmpty()) {
            return null;
        } else {
            return resultados.get(0);
        }
    }

}
