package pe.edu.universidad.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import pe.edu.universidad.entidades.Usuario;
import pe.edu.universidad.service.AutentificationService;

@Named
@SessionScoped
public class beanAutentification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private AutentificationService autentificationService;
	
	private Usuario usuarioform;
	private int idCliente;
	
	public String iniciarSesion() {
	    Usuario usuario = autentificationService.buscarPorNombreUsuario(usuarioform.getNombreUsuario());
	    if (usuario != null && usuario.getContrasena().equals(usuarioform.getContrasena())) {
	        // Iniciar sesión
	        idCliente = usuario.getCliente().getIdCliente();
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	        session.setAttribute("idCliente", idCliente);
	        session.setAttribute("usuario", usuario);
	        return "inicio.xhtml?faces-redirect=true";
	    } else {
	        // Mostrar mensaje de error
	        FacesContext.getCurrentInstance().addMessage(null, null);
	        return null;
	    }
	}

	public Usuario getUsuarioform() {
		return usuarioform;
	}

	public void setUsuarioform(Usuario usuarioform) {
		this.usuarioform = usuarioform;
	}
	
}
