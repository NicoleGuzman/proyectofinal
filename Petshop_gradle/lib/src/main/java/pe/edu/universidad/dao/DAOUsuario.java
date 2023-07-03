package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.dto.DtoUsuarioLogin;



public class DAOUsuario extends Conexion{
	
	public DtoUsuarioLogin usuarioLogin(DtoUsuarioLogin usuariologin) {
	    DtoUsuarioLogin loginValidacion = new DtoUsuarioLogin();
	    Connection cnx = crearCNX();
	    String sql = "SELECT id_usuario, nombre_usuario, contrasena FROM public.usuarios WHERE nombre_usuario = ?;";
	    try {
	        PreparedStatement st = cnx.prepareStatement(sql);
	        st.setString(1, usuariologin.getNombre_usuario());
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            loginValidacion.setId_usuario(rs.getInt(1));
	            loginValidacion.setNombre_usuario(rs.getString(2));
	            loginValidacion.setContrasena(rs.getString(3));
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
	    return loginValidacion;
	}
}
