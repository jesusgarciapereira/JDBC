package ejecucionconsultas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.MiConexion;

public class CreacionTablas {
	public static void main(String[] args) {

		String nombreTabla = "Personas";
		
		try {
			if (crearTabla(nombreTabla)) {
				System.out.println("Tabla \"" + nombreTabla + "\" creada");
			} else {
				System.out.println("No se ha podido crear la Tabla \"" + nombreTabla + "\"");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean crearTabla(String nombreTabla) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		boolean creacionCompletada = false;

		try {

			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos la sentencia de crear una nueva tabla
			String sql = "CREATE TABLE " + nombreTabla + " (\r\n" 
					+ "    id INT,\r\n" 
					+ "    nombre VARCHAR(50),\r\n"
					+ "    apellido VARCHAR(50),\r\n" + "    edad INT,\r\n" + "\r\n"
					+ "	CONSTRAINT PK_Personas PRIMARY KEY (id)\r\n" + ");";
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
