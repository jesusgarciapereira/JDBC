package ejecucionconsultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Ejercicio10 {

	public static void main(String[] args) {
		try {
			agregarColumna10("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Crea una columna denominada "laboral" que contendrá los siguientes valores: estudiante, ocupado, parado, jubilado
	 * 
	 * @param nombreTabla
	 * @throws SQLException
	 */
	public static void agregarColumna10 (String nombreTabla) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		

		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");
			
			//Paso 2: Preparamos el objeto Statement
		    stmt = conn.createStatement();

		    // Los pasos 3 y 4 se pueden hacer en uno solo paso en MySQL con un enum
		    
		    // Paso 3: Modificacion de la tabla
		    String sql = "ALTER TABLE " + nombreTabla + " ADD laboral VARCHAR(15)";
		    stmt.executeUpdate(sql);

		 // Paso 4: Restricción de la tabla
		     sql = "ALTER TABLE " + nombreTabla + " ADD CONSTRAINT CK" + nombreTabla + " CHECK (laboral IN ('estudiante', 'ocupado', 'parado', 'jubilado'))";
		    stmt.executeUpdate(sql);

			System.out.println("=======================");
			System.out.println("Tabla " + nombreTabla + " actualizada");
			
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
