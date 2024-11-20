package ejecucionconsultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Ejercicio6 {

	public static void main(String[] args) {
		try {
			consulta6("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Media de edad de la muestra
	 * 
	 * @param nombreTabla
	 * @throws SQLException
	 */
	public static void consulta6 (String nombreTabla) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		

		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2: Preparamos la consulta SQL con la conexion
			stmt = conn.prepareStatement("SELECT AVG (edad) AS MediaDeEdad FROM "+ nombreTabla + ";");
			
			// Paso 3: Ejecutamos la consulta y almacenamos el resultado en un ResultSet.
			ResultSet resultado = stmt.executeQuery();
			
			// Paso 4: Iteramos por los resultados obtenidos de la consulta.
			while (resultado.next()) {
				System.out.println("=======================");
				System.out.println("Media de edad: " + resultado.getDouble("MediaDeEdad") + " años"); // O getInt() si lo prefieres sin decimales

			}
		
			System.out.println("=======================");
			System.out.println("Esta es la media de edad de todas las personas");
			
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
