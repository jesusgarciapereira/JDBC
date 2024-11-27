package ejecucionconsultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			consulta2("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Listado de los nombres y apellidos ordenados por apellido
	 * 
	 * @param nombreTabla
	 * @throws SQLException
	 */
	public static void consulta2 (String nombreTabla) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null; // Tambien vale el Satatement
		

		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2: Preparamos la consulta SQL con la conexion
			stmt = conn.prepareStatement("SELECT * FROM "+ nombreTabla +" ORDER BY apellido;"); // Procura no consumir muchos recursos
			
			// Paso 3: Ejecutamos la consulta y almacenamos el resultado en un ResultSet.
			ResultSet resultado = stmt.executeQuery();
			
			// Paso 4: Iteramos por los resultados obtenidos de la consulta.
			while (resultado.next()) {
				System.out.println("=======================");
				//System.out.println("ID: " + resultado.getInt("id")); // No hace falta en este ejercicio
				System.out.println("Nombre: " + resultado.getString("nombre"));
				System.out.println("Apellido: " + resultado.getString("apellido"));
				//System.out.println("Edad: " + resultado.getInt("edad"));  // No hace falta en este ejercicio

			}
		
			System.out.println("=======================");
			System.out.println("Estos son todos los nombres y apellidos de las personas ordenadas por el apellido");
			
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
