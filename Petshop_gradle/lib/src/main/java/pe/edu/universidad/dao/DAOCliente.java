package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entity.Cliente;






public class DAOCliente extends Conexion{
	
	//LA FUNCION RECIBE UN OBJETO CLIENTE Y LA INGRESA A LA BASE DE DATOS
	public void agregarCliente(Cliente cliente) {
		Connection cnx = crearCNX();
		String sql = "INSERT INTO public.clientes( nombre, direccion, correo_electronico)	VALUES ( ?, ?, ?);";
		try {
			PreparedStatement st = cnx.prepareStatement(sql);
			st.setInt(1, cliente.getId_cliente());
			st.setString(2, cliente.getDireccion());
			st.setString(3, cliente.getDireccion());
			st.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//LA FUNCION RETORNA UNA LISTA DE TODOS LOS CLIENTES
	public List<Cliente> consultarClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		Connection cnx = crearCNX();
		String sql = "SELECT id_cliente, nombre, direccion, correo_electronico FROM public.clientes;";
		try {
			PreparedStatement st = cnx.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();			
				cliente.setId_cliente(rs.getInt(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDireccion(rs.getString(3));
				cliente.setCorreo_electronico(rs.getString(4));
				listaCliente.add(cliente);
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
		return listaCliente;
	}

}
