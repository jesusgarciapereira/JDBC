package ejecucionconsultas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class InsercionDeDatosEnTabla {
	public static void main(String[] args) {

		String nombreTabla = "Personas";

		try {
			if (insertarDatos(nombreTabla)) {
				System.out.println("Datos insertados en la Tabla \"" + nombreTabla + "\"");
			} else {
				System.out.println("No se han podido insertar los datos en la Tabla \"" + nombreTabla + "\"");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean insertarDatos(String nombreTabla) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		boolean creacionCompletada = false;

		try {

			// Paso 1.Previamente habremos realizado la conexión
			conn = MiConexion.miConexion();
			System.out.println("Nos hemos conectado a la Base de Datos");

			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos las sentencias para insertar los datos en la tabla
			String[] todosLosInsert = ArrayInsercionDeDatosEnTabla.arrayConTodo(nombreTabla);

			// Paso 4. Ejecutar todas las sentencias
			for (String sql : todosLosInsert) {
				stmt.executeUpdate(sql);
			}

			creacionCompletada = true;

		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// insercion
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
