package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.service.InventarioService;

@Named
@SessionScoped
public class beanInventario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private InventarioService servicioGestorCatalogo;
	
	private List<DtoCatalogoProducto> listaCatalogo;
	
	@PostConstruct
	public void getcatalogo() {
		setListaCatalogo(servicioGestorCatalogo.consultarCatalogo());
	}

	public List<DtoCatalogoProducto> getListaCatalogo() {
		return listaCatalogo;
	}

	public void setListaCatalogo(List<DtoCatalogoProducto> listaCatalogo) {
		this.listaCatalogo = listaCatalogo;
	}
}
