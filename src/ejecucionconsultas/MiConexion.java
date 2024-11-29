package ejecucionconsultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {

	public static void main(String[] args) {

		if (miConexion() != null)
			System.out.println("Conexión exitosa");
		else
			System.out.println("No se ha podido llevar a cabo la conexion");

	}

	public static Connection miConexion() {
		// Antes de la direccion, debes poner antes jdbc:mysql://
		// El puerto es 3306
		String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_jgarcia"; // /ad2425_jgarcia NO HACE FALTA
		String usuario = "jgarcia";
		String contrasennia = "12345";

		// Declaro la conexion que devolvera
		Connection conn = null;

		try {
			// No olvides el Class para establecer la conexion
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, contrasennia);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
