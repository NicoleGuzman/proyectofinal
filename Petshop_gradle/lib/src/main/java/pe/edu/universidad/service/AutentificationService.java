package pe.edu.universidad.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;

import pe.edu.universidad.entidades.Usuario;


@Path("AutentificationService")
@Stateless
@LocalBean
public class AutentificationService {
	@PersistenceContext(unitName = "petshop_jpa")
	private EntityManager em;
	
	public Usuario buscarUsuario(String nombreUsuario, String contrasena) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasena = :contrasena", Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("contrasena", contrasena);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios.isEmpty()) {
          return null;
        } else {
          return usuarios.get(0);
        }
      }
	public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        List<Usuario> resultados = query.getResultList();
        if (resultados.isEmpty()) {
            return null;
        } else {
            return resultados.get(0);
        }
    }
}
