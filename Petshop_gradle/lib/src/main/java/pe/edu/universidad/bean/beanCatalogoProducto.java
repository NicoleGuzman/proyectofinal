package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.gestorproductos.ServicioGestorCatalogo;

@Named
@SessionScoped
public class beanCatalogoProducto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioGestorCatalogo servicioGestorCatalogo;
	
	private List<DtoCatalogoProducto> listaCatalogo;
	
	@PostConstruct
	public void getcatalogo() {
		setListaCatalogo(servicioGestorCatalogo.ConsultarCatalogo());
	}

	public List<DtoCatalogoProducto> getListaCatalogo() {
		return listaCatalogo;
	}

	public void setListaCatalogo(List<DtoCatalogoProducto> listaCatalogo) {
		this.listaCatalogo = listaCatalogo;
	}
}
