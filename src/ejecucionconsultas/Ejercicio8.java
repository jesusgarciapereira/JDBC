package ejecucionconsultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Ejercicio8 {

	public static void main(String[] args) {
		try {
			consulta8("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Listado de las personas en la franja de edad comprendida entre los 24 y los 32 años.
	 * 
	 * @param nombreTabla
	 * @throws SQLException
	 */
	public static void consulta8 (String nombreTabla) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		

		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2: Preparamos la consulta SQL con la conexion
			stmt = conn.prepareStatement("SELECT * FROM "+ nombreTabla + " WHERE edad >= 24 AND EDAD <= 32");
			
			// Paso 3: Ejecutamos la consulta y almacenamos el resultado en un ResultSet.
			ResultSet resultado = stmt.executeQuery();
			
			// Paso 4: Iteramos por los resultados obtenidos de la consulta.
			while (resultado.next()) {
				System.out.println("=======================");
				System.out.println("ID: " + resultado.getInt("id")); 
				System.out.println("Nombre: " + resultado.getString("nombre"));
				System.out.println("Apellido: " + resultado.getString("apellido")); 
				System.out.println("Edad: " + resultado.getInt("edad"));  

			}
		
			System.out.println("=======================");
			System.out.println("Estas son todas las personas con edad entre 24 y 32 años");
			
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
