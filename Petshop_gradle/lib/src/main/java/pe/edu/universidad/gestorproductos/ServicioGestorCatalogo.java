package pe.edu.universidad.gestorproductos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pe.edu.universidad.dao.DAOProducto;
import pe.edu.universidad.dto.DtoCatalogoProducto;
import pe.edu.universidad.entity.Producto;

@Stateless
@LocalBean
public class ServicioGestorCatalogo {
	
	public List<DtoCatalogoProducto> ConsultarCatalogo(){
		DAOProducto daoproducto = new DAOProducto();
		List<DtoCatalogoProducto> listardtocatalogo = new ArrayList<>();
		
		List<Producto> listacatalogo = daoproducto.consultarProductos();
		
		for (Producto producto : listacatalogo) {
			
			DtoCatalogoProducto dtoCatalogoProducto = new DtoCatalogoProducto();
			
			dtoCatalogoProducto.setId_producto(producto.getId_producto());
			dtoCatalogoProducto.setNombre(producto.getNombre());
			dtoCatalogoProducto.setDescripcion(producto.getDescripcion());
			dtoCatalogoProducto.setPrecio(producto.getPrecio());
			dtoCatalogoProducto.setStock(producto.getStock());
			dtoCatalogoProducto.setImagen(producto.getImagen());
			listardtocatalogo.add(dtoCatalogoProducto);
		}
		return listardtocatalogo;
	}
	
}
