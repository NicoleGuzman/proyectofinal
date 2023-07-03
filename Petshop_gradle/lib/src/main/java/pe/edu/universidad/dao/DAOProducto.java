package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entity.Producto;





public class DAOProducto  extends Conexion{
	//LA FUNCION RECIBE UN OBJETO CLIENTE Y LA INGRESA A LA BASE DE DATOS
		
	
		//ESTA FUNCION REGRESA UNA LISTA DE TODOS LOS PRODUCTOS
		public List<Producto> consultarProductos() {
			List<Producto> listaProducto = new ArrayList<>();
			Connection cnx = crearCNX();
			String sql = "SELECT id_producto, nombre, descripcion, precio, stock, imagen, proveedor_id FROM public.productos;";
			try {
				PreparedStatement st = cnx.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Producto producto = new Producto();			
					producto.setId_producto(rs.getInt(1));
					producto.setNombre(rs.getString(2));
					producto.setDescripcion(rs.getString(3));
					producto.setPrecio(rs.getDouble(4));
					producto.setStock(rs.getInt(5));
					producto.setImagen(rs.getString(6));									
					
					listaProducto.add(producto);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					cnx.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return listaProducto;
		}
		
}
