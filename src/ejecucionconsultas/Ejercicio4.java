package ejecucionconsultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			consulta4("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Listado de los nombres que comiencen por "J" ordenados por apellido
	 * 
	 * @param nombreTabla
	 * @throws SQLException
	 */
	public static void consulta4(String nombreTabla) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2: Preparamos la consulta SQL con la conexion
			stmt = conn.prepareStatement("SELECT * FROM " + nombreTabla + " WHERE nombre LIKE 'J%' ORDER BY apellido;");

			// Paso 3: Ejecutamos la consulta y almacenamos el resultado en un ResultSet.
			ResultSet resultado = stmt.executeQuery();

			// Paso 4: Iteramos por los resultados obtenidos de la consulta.
			while (resultado.next()) {
				System.out.println("=======================");
				// System.out.println("ID: " + resultado.getInt("id")); // No hace falta en este
				// ejercicio
				System.out.println("Nombre: " + resultado.getString("nombre"));
				// System.out.println("Apellido: " + resultado.getString("apellido")); // No
				// hace falta en este ejercicio
				// System.out.println("Edad: " + resultado.getInt("edad")); // No hace falta en
				// este ejercicio

			}

			System.out.println("=======================");
			System.out.println(
					"Estos son todos los nombres de las personas que emìezan por 'J' ordenadas por el apellido");

		} catch (SQLException e) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// consulta
			e.printStackTrace();
		} finally {
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}

	}

}
