package ejecucionconsultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Ejercicio11 {

	public static void main(String[] args) {
		try {
			agregarColumna10("Personas");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Actualiza la columna laboral con el siguiente criterio: 
	 * Los menores de 18 son estudiantes 
	 * Los mayores de 65 son jubilados 
	 * Los de edad impar, que no pertenezcan a los colectivos anteriores, están parados 
	 * El resto, ocupados
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

		    // Paso 3: Actualizacion de los datos
		    String sql = "UPDATE " + nombreTabla + " SET laboral = 'estudiante' WHERE edad < 18";
		    stmt.executeUpdate(sql);
		    
		    sql = "UPDATE " + nombreTabla + " SET laboral = 'jubilado' WHERE edad > 65";
		    stmt.executeUpdate(sql);
		    
		    sql = "UPDATE " + nombreTabla + " SET laboral = 'parado' WHERE (laboral != 'estudiante' AND laboral != 'jubilado' OR laboral IS NULL) AND edad % 2 = 1";
		    stmt.executeUpdate(sql);
		    
		    sql = "UPDATE " + nombreTabla + " SET laboral = 'ocupado' WHERE laboral IS NULL";
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
