package pe.edu.universidad.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import pe.edu.universidad.dto.DtoUsuarioLogin;
import pe.edu.universidad.entidades.Usuario;
import pe.edu.universidad.service.AutentificationService;

@Named
@SessionScoped
public class beanAutentification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private AutentificationService autentificationService;
	
	private Usuario usuarioform;
	private DtoUsuarioLogin login = new DtoUsuarioLogin();
	private Usuario logeado;
	private int idCliente;
	
	public void iniciarSesion() throws IOException {
		setLogeado(autentificationService.buscarUsuario(login.getNombre_usuario(), login.getContrasena()));	
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String url = externalContext.getRequestContextPath() + "/index.xhtml";
		externalContext.redirect(url);
	}
	

	public Usuario getUsuarioform() {
		return usuarioform;
	}

	public void setUsuarioform(Usuario usuarioform) {
		this.usuarioform = usuarioform;
	}

	public DtoUsuarioLogin getLogin() {
		return login;
	}

	public void setLogin(DtoUsuarioLogin login) {
		this.login = login;
	}

	public Usuario getLogeado() {
		return logeado;
	}

	public void setLogeado(Usuario logeado) {
		this.logeado = logeado;
	}
	
}
