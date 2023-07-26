package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoCatalogoInventario;
import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.service.InventarioService;

@Named
@SessionScoped
public class beanInventario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private InventarioService inventarioService;
	
	private List<DtoCatalogoInventario> listaCatalogo;
	
	@PostConstruct
	public void getcatalogo() {
		setListaCatalogo(inventarioService.consultarCatalogo());
	}

	public List<DtoCatalogoInventario> getListaCatalogo() {
		return listaCatalogo;
	}

	public void setListaCatalogo(List<DtoCatalogoInventario> listaCatalogo) {
		this.listaCatalogo = listaCatalogo;
	}
}
