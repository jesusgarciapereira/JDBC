package ejecucionconsultas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.MiConexion;

public class CreacionBBDD {
	public static void main(String[] args) {
		
		String nombreBBDD = "PersonasJDBC";

		try {
			if (crearBBDD(nombreBBDD)) {
				System.out.println("Base de datos \"" + nombreBBDD + "\" creada");
			} else {
				System.out.println("No se ha podido crear la Base de datos \"" + nombreBBDD + "\"");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean crearBBDD(String nombreBBDD) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		boolean creacionCompletada = false;

		try {

			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();

			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos la sentencia de crear una nueva base de datos
			String sql = "CREATE DATABASE " + nombreBBDD;
			// Paso 4. Ejecutar la sentencia
			stmt.executeUpdate(sql);

			creacionCompletada = true;

		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// creacion
			se.printStackTrace();
		} catch (Exception e) {
			// Gestionamos los posibles errores
			e.printStackTrace();
		} finally {
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}

		return creacionCompletada;
	}
}
