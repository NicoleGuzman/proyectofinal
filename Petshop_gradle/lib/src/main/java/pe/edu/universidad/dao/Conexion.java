package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexion {
	public Connection crearCNX() {
		Connection cnx = null;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/jdbc/hotelutp");
			cnx = ds.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return cnx;
	}

	public void cerrarCNX(Connection cnx) {
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
